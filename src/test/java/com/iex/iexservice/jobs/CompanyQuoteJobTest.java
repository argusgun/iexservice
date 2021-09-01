package com.iex.iexservice.jobs;

import com.iex.iexservice.services.MyExecutorService;
import com.iex.iexservice.services.ViewService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class CompanyQuoteJobTest {

    @Autowired
    private  CompanyQuoteJob companyQuoteJob;
    private Environment environment;

    @MockBean
    MyExecutorService myExecutorService;

    @MockBean
    ViewService viewService;
    @Test
    void executeAppService() {
        Mockito.verify(myExecutorService,Mockito.times(1)).execute();
    }

    @Test
    void executeView() {
        Mockito.verify(viewService,Mockito.times(1)).viewTopCompanies();
        Mockito.verify(viewService,Mockito.times(1)).viewTopStocks();
    }
}