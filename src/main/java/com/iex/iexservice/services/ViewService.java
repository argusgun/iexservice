package com.iex.iexservice.services;

import com.iex.iexservice.entities.Company;
import com.iex.iexservice.entities.Quote;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
public class ViewService implements CommandLineRunner {
    @Autowired
    QuoteRepo quoteRepo;
    @Autowired
    ChangeQuoteRepo changeQuoteRepo;
    @Autowired
    CompanyRepo companyRepo;
    Logger logger = LoggerFactory.getLogger(ViewService.class);
    @Override
    public void run(String... args) {
        while (true) {
            try {
                Thread.sleep(5000);

                List<Quote> quoteList =quoteRepo.findAll(Sort.by(Sort.Direction.DESC, "previousVolume ")).stream()
                        .limit(5)
                        .collect(Collectors.toList());
                logger.info("The top 5 highest value stocks:"+quoteList);
                List<Company> companyList = changeQuoteRepo.findAll(Sort.by(Sort.Direction.DESC,"change")).stream()
                        .limit(5)
                        .map(p -> companyRepo.findById(p.getSymbol()).get())
                        .collect(Collectors.toList());
                logger.info("The most recent 5 companies that have the greatest change:"+companyList);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
