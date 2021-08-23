package com.iex.iexservice.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iex.iexservice.entities.*;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import com.iex.iexservice.repositories.SymbolRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@Data
public class MyExecutorService implements CommandLineRunner {

    @Autowired
    QuoteRepo quoteRepo;
    @Autowired
    SymbolRepo symbolRepo;
    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    ChangeQuoteRepo changeQuoteRepo;

    private final ExecutorService threadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    private Symbols symbols;

    private CompletableFuture<Symbols> getSymbolsFromIex() {
        return CompletableFuture.supplyAsync(() -> {
            Symbols symbols = null;
            try {
                symbols = new ObjectMapper()
                        .readerFor(Symbols.class)
                        .readValue(new URL("https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return symbols;
        }, threadPool);
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

    private List<CompletableFuture<Void>> equalsCompanies() {
        return getSymbols().getSymbols().stream()
                .map(s -> CompletableFuture.runAsync(() -> {
                    try {
                        Company company = new ObjectMapper()
                                .readerFor(Company.class)
                                .readValue(new URL("https://sandbox.iexapis.com/stable/stock/" + s.getSymbol() + "/company?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
                        if (!company.equals(getCompaniesFromDB(company.getSymbol())) || getCompaniesFromDB(company.getSymbol()) == null)
                            companyRepo.save(company);
                    } catch (IOException exception) {
//                        exception.printStackTrace();
                    }
                }, threadPool))
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<Quote>> getQuotesFromIex() {
        return getSymbols().getSymbols().stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    Quote quote = null;
                    try {
                        quote = new ObjectMapper()
                                .readerFor(Quote.class)
                                .readValue(new URL("https://sandbox.iexapis.com/stable/stock/" + s.getSymbol() + "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
                    } catch (IOException exception) {
//                        exception.printStackTrace();
                    }
                    return quote;
                }, threadPool))
                .collect(Collectors.toList());
    }

    @Override
    public void run(String... args) {
        try {
            while (true) {
                setSymbols(getSymbolsFromIex().get());

                equalsCompanies().stream().forEach(p -> {
                    try {

//                    System.out.println("Company");
                        p.get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });
                getQuotesFromIex().stream().forEach(p -> {
                    try {
//                        System.out.println("Quote");
                        Quote quote = p.get();
                        if (quote != null) {
                            Quote qdb = null;

                            Optional<Quote> qdb1 = quoteRepo.findById(quote.getSymbol());
                            if (!Optional.empty().equals(qdb1)) {
                                qdb = qdb1.get();
                                double d;
                                if (quote.getLatestPrice() != null && qdb.getLatestPrice() != null) {
                                    d = Math.abs(quote.getLatestPrice() - qdb.getLatestPrice());
                                    changeQuoteRepo.save(new ChangeQuote(quote.getSymbol(), d));
                                }

                            }
                            quoteRepo.save(quote);
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
