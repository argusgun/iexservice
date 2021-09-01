package com.iex.iexservice.services;

import com.iex.iexservice.dto.SymbolDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyExecutorServiceTest {
    @Autowired
    private Environment environment;

    @MockBean
    MyExecutorService myExecutorService;

    @Test
    public void execute(){
        RestTemplate restTemplate =new RestTemplate();
        StringBuilder stringBuilder = new StringBuilder(environment.getProperty("url"));
        stringBuilder.append("/ref-data/symbols?");
        stringBuilder.append(environment.getProperty("tkn"));
        assertEquals(HttpStatus.OK,restTemplate.getForEntity(stringBuilder.toString(), SymbolDto[].class).getStatusCode());
    }

}