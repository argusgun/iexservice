package com.iex.iexservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
public class ApplConfig {
    private  final Environment environment;

    @Autowired
    public ApplConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public RestTemplate restTemplateSymbol(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean
    public ScheduledExecutorService threadPool() throws NullPointerException{
        return new ScheduledThreadPoolExecutor(Integer.parseInt(environment.getProperty("servicepool")));
    }


}
