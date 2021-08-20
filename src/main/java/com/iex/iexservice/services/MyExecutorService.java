package com.iex.iexservice.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.iex.iexservice.entities.Company;
import com.iex.iexservice.entities.Quote;
import com.iex.iexservice.entities.Symbol;
import com.iex.iexservice.entities.Symbols;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import com.iex.iexservice.repositories.SymbolRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

    private final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
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
        return companyRepo.findById(id).get();
    }

    private List<CompletableFuture<Void>> equalsCompanies() {
        return getSymbols().getSymbols().stream()
                .map(s -> CompletableFuture.runAsync(() -> {
                    try {
                        Company company = new ObjectMapper()
                                .readerFor(Company.class)
                                .readValue(new URL("https://sandbox.iexapis.com/stock/" + s.getSymbol() + "/company?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
                        if (!company.equals(getCompaniesFromDB(company.getSymbol()))) companyRepo.save(company);
                    } catch (IOException exception) {
                        exception.printStackTrace();
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
                                .readValue(new URL("https://sandbox.iexapis.com/stock/" + s.getSymbol() + "/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    return quote;
                }, threadPool))
                .collect(Collectors.toList());
    }

    @Override
    public void run(String... args) throws Exception {
        setSymbols(getSymbolsFromIex().get());
        equalsCompanies().stream().forEach(p -> {
            try {
                p.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        getQuotesFromIex().stream().forEach(p -> {
            try {
                 quoteRepo.save(p.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

}
