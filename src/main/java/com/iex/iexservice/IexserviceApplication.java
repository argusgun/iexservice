package com.iex.iexservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iex.iexservice.entities.Symbol;
import com.iex.iexservice.entities.Symbols;
import com.iex.iexservice.repositories.SymbolRepo;
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
    private SymbolRepo symbolRepo;

    public static void main(String[] args) {
        SpringApplication.run(IexserviceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        symbolRepo.deleteAll();
        Symbols symbols =null;
        try {
            symbols = new ObjectMapper()
                    .readerFor(Symbols.class)
                    .readValue(new URL("https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        symbolRepo.saveAll(symbols.getSymbols());
        symbolRepo.findAll().stream().forEach(System.out::println);

    }
}
