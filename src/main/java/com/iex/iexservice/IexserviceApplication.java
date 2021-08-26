package com.iex.iexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableMongoRepositories
public class IexserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IexserviceApplication.class, args);
    }
}
