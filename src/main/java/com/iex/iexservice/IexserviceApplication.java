package com.iex.iexservice;

import com.iex.iexservice.services.MyExecutorService;
import com.iex.iexservice.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class IexserviceApplication implements CommandLineRunner {
    @Autowired
    MyExecutorService myExecutorService;
    @Autowired
    ViewService viewService;
    ExecutorService service = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        SpringApplication.run(IexserviceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        CompletableFuture.runAsync(() -> {
            myExecutorService.run();
        }, service);
        CompletableFuture.runAsync(() -> {
            viewService.run();
        }, service);
    }
}
