package com.iex.iexservice.services;


import com.iex.iexservice.DAO.ChangeQuoteDAO;
import com.iex.iexservice.DAO.CompanyDAO;
import com.iex.iexservice.DAO.QuoteDAO;
import com.iex.iexservice.entities.Company;
import com.iex.iexservice.entities.Quote;
import com.iex.iexservice.entities.Symbol;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
@Data
public class MyExecutorService {
    private final RestTemplate restTemplate;
    private final Environment environment;
    private final QuoteRepo quoteRepo;
    private final CompanyRepo companyRepo;
    private final ChangeQuoteRepo changeQuoteRepo;
    private final Logger logger = LoggerFactory.getLogger(MyExecutorService.class);
    private final ScheduledExecutorService threadPool;

    @Autowired
    public MyExecutorService(ScheduledExecutorService threadPool,RestTemplate restTemplate,Environment environment,QuoteRepo quoteRepo, CompanyRepo companyRepo, ChangeQuoteRepo changeQuoteRepo) {
        this.quoteRepo = quoteRepo;
        this.companyRepo = companyRepo;
        this.changeQuoteRepo = changeQuoteRepo;
        this.environment=environment;
        this.restTemplate=restTemplate;
        this.threadPool=threadPool;
    }

    private CompletableFuture<Symbol[]> getSymbolsFromIex(ExecutorService threadPool) {
        logger.info("Start ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(environment.getProperty("url"));
        stringBuffer.append("/ref-data/symbols?");
        stringBuffer.append(environment.getProperty("tkn"));
        return CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject(stringBuffer.toString(), Symbol[].class)
                , threadPool);
    }

    private CompanyDAO getCompaniesFromDB(String id) {
        try {
            CompanyDAO company = companyRepo.findById(id).get();
            return company;
        } catch (Exception e) {
//            logger.error(e.getMessage());
            return null;
        }
    }

    private List<CompletableFuture<Company>> getCompaniesFromIex(ExecutorService threadPool, List<Symbol> symbols) {

        return symbols.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(environment.getProperty("url"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/company?");
                    stringBuffer.append(environment.getProperty("tkn"));
                    Company company= restTemplate.getForObject(stringBuffer.toString(), Company.class);
//                    System.out.println(company);
                    return company;
                }, threadPool))
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<Quote>> getQuotesFromIex(ExecutorService threadPool, List<Symbol> symbols) {

        return symbols.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(environment.getProperty("url"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/quote?");
                    stringBuffer.append(environment.getProperty("tkn"));
                    Quote quote = restTemplate.getForObject(stringBuffer.toString(), Quote.class);
                    return quote;
                }, threadPool))
                .collect(Collectors.toList());
    }

    public void execute() {
        try {
            List<Symbol> symbols = Arrays.asList(getSymbolsFromIex(threadPool).get());
            logger.info("Get Symbols from IEX succeed");
            List<Company> companies = getCompaniesFromIex(threadPool, symbols).stream()
                    .map(p -> {
                        try {
                         return p.get();
                        } catch (InterruptedException e) {
//                            logger.error(e.getMessage());
                            return null;
                        } catch (ExecutionException e) {
//                            logger.error(e.getMessage());
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            List<CompanyDAO> companyDAOList=companies.stream()
                    .filter(Objects::nonNull)
                    .map(p -> CompanyDAO.fromEntityToDao(p))
                    .collect(Collectors.toList());
            companyRepo.saveAll(companyDAOList);
            logger.info("Save Companies to DB succeed");
            List<QuoteDAO> quotes = getQuotesFromIex(threadPool, symbols).stream()
                    .map(p -> {
                        try {
                            return QuoteDAO.fromEntityToDAO(p.get());
                        } catch (InterruptedException e) {
//                            logger.error(e.getMessage());
                            return null;
                        } catch (ExecutionException e) {
//                            logger.error(e.getMessage());
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            List<QuoteDAO> quoteDAOList=quotes.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            quoteRepo.saveAll(quoteDAOList);
            logger.info("Save Quotes to DB succeed");
            List<ChangeQuoteDAO> changeQuotes = quoteDAOList.stream()
                    .map(p -> {
                        if(p!=null) {
                            Optional<QuoteDAO> qdb1 = quoteRepo.findById(p.getSymbol());
                            if (!Optional.empty().equals(qdb1)) {
                                QuoteDAO qdb = qdb1.get();
                                double d;
                                if (p.getLatestPrice() != null && qdb.getLatestPrice() != null) {
                                    d = Math.abs(p.getLatestPrice() - qdb.getLatestPrice());
                                    return new ChangeQuoteDAO(p.getSymbol(), d);
                                }
                                return null;

                            }
                        }
                                return null;
                            }
                    )
                    .collect(Collectors.toList());
            List<ChangeQuoteDAO> changeQuoteList=changeQuotes.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            changeQuoteRepo.saveAll(changeQuoteList);
            logger.info("Save Changes for Quotes to DB succeed");
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }

}
