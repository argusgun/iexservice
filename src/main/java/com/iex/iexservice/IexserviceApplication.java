package com.iex.iexservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iex.iexservice.entities.Quote;
import com.iex.iexservice.entities.Symbol;
import com.iex.iexservice.entities.Symbols;
import com.iex.iexservice.repositories.QuoteRepo;
import com.iex.iexservice.repositories.SymbolRepo;
import com.iex.iexservice.services.MyExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class IexserviceApplication implements CommandLineRunner {
    @Autowired
    private QuoteRepo quoteRepo;
    @Autowired
    MyExecutorService myExecutorService;

    public static void main(String[] args) {
        SpringApplication.run(IexserviceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        myExecutorService.run();
        quoteRepo.findTopByPreviousVolume().stream().forEach(System.out::println);

    }
}
