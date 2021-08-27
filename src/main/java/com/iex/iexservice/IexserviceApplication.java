package com.iex.iexservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class IexserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IexserviceApplication.class, args);
    }
}
