package com.iex.iexservice.services;


import com.iex.iexservice.entities.ChangeQuoteEntity;
import com.iex.iexservice.entities.CompanyEntity;
import com.iex.iexservice.entities.QuoteEntity;
import com.iex.iexservice.dto.CompanyDto;
import com.iex.iexservice.dto.QuoteDto;
import com.iex.iexservice.dto.SymbolDto;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
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

    private CompletableFuture<SymbolDto[]> getSymbolsFromIex(ExecutorService threadPool) {
        logger.info("Start ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(environment.getProperty("url"));
        stringBuffer.append("/ref-data/symbols?");
        stringBuffer.append(environment.getProperty("tkn"));
        return CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject(stringBuffer.toString(), SymbolDto[].class)
                , threadPool);
    }

    private CompanyEntity getCompaniesFromDB(String id) {
        try {
            CompanyEntity company = companyRepo.findById(id).get();
            return company;
        } catch (Exception e) {
//            logger.error(e.getMessage());
            return null;
        }
    }

    private List<CompletableFuture<CompanyDto>> getCompaniesFromIex(ExecutorService threadPool, List<SymbolDto> symbolDtos) {

        return symbolDtos.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(environment.getProperty("url"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/company?");
                    stringBuffer.append(environment.getProperty("tkn"));
                    CompanyDto companyDto = restTemplate.getForObject(stringBuffer.toString(), CompanyDto.class);
//                    System.out.println(company);
                    return companyDto;
                }, threadPool))
                .collect(Collectors.toList());
    }

    private List<CompletableFuture<QuoteDto>> getQuotesFromIex(ExecutorService threadPool, List<SymbolDto> symbolDtos) {

        return symbolDtos.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(environment.getProperty("url"));
                    stringBuffer.append("/stock/");
                    stringBuffer.append(s.getSymbol());
                    stringBuffer.append("/quote?");
                    stringBuffer.append(environment.getProperty("tkn"));
                    QuoteDto quoteDto = restTemplate.getForObject(stringBuffer.toString(), QuoteDto.class);
                    return quoteDto;
                }, threadPool))
                .collect(Collectors.toList());
    }

    public void execute() {
        try {
            List<SymbolDto> symbolDtos = Arrays.asList(getSymbolsFromIex(threadPool).get());
            logger.info("Get Symbols from IEX succeed");
            List<CompanyDto> companies = getCompaniesFromIex(threadPool, symbolDtos).stream()
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
            List<CompanyEntity> companyEntityList =companies.stream()
                    .filter(Objects::nonNull)
                    .map(p -> CompanyEntity.fromDtoToEntity(p))
                    .collect(Collectors.toList());
            companyRepo.saveAll(companyEntityList);
            logger.info("Save Companies to DB succeed");
            List<QuoteEntity> quotes = getQuotesFromIex(threadPool, symbolDtos).stream()
                    .map(p -> {
                        try {
                            return QuoteEntity.fromDtoToEntity(p.get());
                        } catch (InterruptedException e) {
//                            logger.error(e.getMessage());
                            return null;
                        } catch (ExecutionException e) {
//                            logger.error(e.getMessage());
                            return null;
                        }
                    })
                    .collect(Collectors.toList());
            List<QuoteEntity> quoteEntityList =quotes.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            quoteRepo.saveAll(quoteEntityList);
            logger.info("Save Quotes to DB succeed");
            List<ChangeQuoteEntity> changeQuotes = quoteEntityList.stream()
                    .map(p -> {
                        if(p!=null) {
                            Optional<QuoteEntity> qdb1 = quoteRepo.findById(p.getSymbol());
                            if (!Optional.empty().equals(qdb1)) {
                                QuoteEntity qdb = qdb1.get();
                                Double d;
                                if (p.getLatestPrice() != null && qdb.getLatestPrice() != null) {
                                    d = Math.abs(p.getLatestPrice()-qdb.getLatestPrice());
                                    ChangeQuoteEntity changeQuoteEntity = new ChangeQuoteEntity();
                                    changeQuoteEntity.setSymbol(p.getSymbol());
                                    changeQuoteEntity.setChangePrice(d);
                                    return changeQuoteEntity;
                                }
                                return null;

                            }
                        }
                                return null;
                            }
                    )
                    .collect(Collectors.toList());
            List<ChangeQuoteEntity> changeQuoteList=changeQuotes.stream()
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
