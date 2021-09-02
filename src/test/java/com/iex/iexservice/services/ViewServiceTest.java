package com.iex.iexservice.services;

import com.iex.iexservice.jobs.CompanyQuoteJob;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
class ViewServiceTest {
    @Autowired
    private ViewService viewService;
    @MockBean
    private QuoteRepo quoteRepo;
    @MockBean
    private ChangeQuoteRepo changeQuoteRepo;

    @Test
    void viewTopStocks() {
        viewService.viewTopStocks();
        Mockito.verify(quoteRepo,Mockito.times(1)).findAll(Sort.by(Sort.Direction.DESC, "previousVolume "));
    }

    @Test
    void viewTopCompanies() {
        viewService.viewTopCompanies();
        Mockito.verify(changeQuoteRepo,Mockito.times(1)).findAll(Sort.by(Sort.Direction.DESC, "change"));
    }
}