package com.iex.iexservice.services;


import com.iex.iexservice.entities.*;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import com.iex.iexservice.repositories.SymbolRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Service
@Data
public class MyExecutorService {

    private final QuoteRepo quoteRepo;
    private final SymbolRepo symbolRepo;
    private final CompanyRepo companyRepo;
    private final ChangeQuoteRepo changeQuoteRepo;
    private final Logger logger = LoggerFactory.getLogger(MyExecutorService.class);
    private final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    public MyExecutorService(QuoteRepo quoteRepo, SymbolRepo symbolRepo, CompanyRepo companyRepo, ChangeQuoteRepo changeQuoteRepo) {
        this.quoteRepo = quoteRepo;
        this.symbolRepo = symbolRepo;
        this.companyRepo = companyRepo;
        this.changeQuoteRepo = changeQuoteRepo;
    }

    private CompletableFuture<Symbols> getSymbolsFromIex(ExecutorService threadPool) {
        logger.info("Start ");
        RestTemplate restTemplate = new RestTemplate();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getenv("site"));
        stringBuffer.append("/ref-data/symbols?");
        stringBuffer.append(System.getenv("tkn"));
        return CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject(stringBuffer.toString(), Symbols.class)
                , threadPool);
    }

    private List<Symbol> getSymbolsFromDB() {
        return symbolRepo.findAll();
    }

    private Company getCompaniesFromDB(String id) {
        try {
            Company company = companyRepo.findById(id).get();
            return company;
        } catch (Exception e) {
            return null;
        }
    }

    private List<CompletableFuture<Company>> getCompaniesFromIex(ExecutorService threadPool, Symbols symbols) {
        RestTemplate restTemplate = new RestTemplate();

        return symbols.getSymbols().stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(System.getenv("site"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/company?");
                    stringBuffer.append(System.getenv("tkn"));
                    return restTemplate.getForObject(stringBuffer.toString(), Company.class);
                }, threadPool))
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<Quote>> getQuotesFromIex(ExecutorService threadPool, Symbols symbols) {
        RestTemplate restTemplate = new RestTemplate();

        return symbols.getSymbols().stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(System.getenv("site"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/quote?");
                    stringBuffer.append(System.getenv("tkn"));
                    Quote quote = restTemplate.getForObject(stringBuffer.toString(), Quote.class);
                    return quote;
                }, threadPool))
                .collect(Collectors.toList());
    }

    public void execute() {
        try {
            Symbols symbols = getSymbolsFromIex(threadPool).get();
            logger.info("Get Symbols from IEX succeed");
            List<Company> companies = getCompaniesFromIex(threadPool, symbols).stream()
                    .filter(p -> {
                        Company company = null;
                        try {
                            company = p.get();
                        } catch (InterruptedException e) {
                            return false;
                        } catch (ExecutionException e) {
                            return false;
                        }
                        if (!company.equals(getCompaniesFromDB(company.getSymbol())) || getCompaniesFromDB(company.getSymbol()) == null)
                            return true;
                        else return false;
                    })
                    .map(p -> {
                        try {
                            return p.get();
                        } catch (InterruptedException e) {
                            return null;
                        } catch (ExecutionException e) {
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            companyRepo.saveAll(companies);
            logger.info("Save Companies to DB succeed");
            List<Quote> quotes = getQuotesFromIex(threadPool, symbols).stream()
                    .filter(p -> {
                        try {
                            if(p.get()!=null) return true;
                        } catch (InterruptedException e) {
                            return false;
                        } catch (ExecutionException e) {
                            return false;
                        }
                        return false;
                    })
                    .map(p -> {
                        try {
                            return p.get();
                        } catch (InterruptedException e) {
                            return null;
                        } catch (ExecutionException e) {
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            quoteRepo.saveAll(quotes);
            logger.info("Save Quotes to DB succeed");
            List<ChangeQuote> changeQuotes = quotes.stream()
                    .map(p -> {
                                Optional<Quote> qdb1 = quoteRepo.findById(p.getSymbol());
                                if (!Optional.empty().equals(qdb1)) {
                                    Quote qdb = qdb1.get();
                                    double d;
                                    if (p.getLatestPrice() != null && qdb.getLatestPrice() != null) {
                                        d = Math.abs(p.getLatestPrice() - qdb.getLatestPrice());
                                        return new ChangeQuote(p.getSymbol(), d);
                                    }
                                    return null;

                                }
                                return null;
                            }
                    )
                    .collect(Collectors.toList());
            List<ChangeQuote> changeQuoteList=changeQuotes.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            changeQuoteRepo.saveAll(changeQuoteList);
            logger.info("Save Changes for Quotes to DB succeed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
