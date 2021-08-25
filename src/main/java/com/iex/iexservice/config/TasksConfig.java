package com.iex.iexservice.config;

import com.iex.iexservice.services.MyExecutorService;
import com.iex.iexservice.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@EnableScheduling
    public class TasksConfig {
    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    private final MyExecutorService executorService;
    private final ViewService viewService;

    @Autowired
    public TasksConfig(MyExecutorService executorService, ViewService viewService) {
        this.executorService = executorService;
        this.viewService = viewService;
    }

    @Scheduled(fixedDelay = 0)
    public void executeAppService(){
    executorService.execute(threadPool);
    }

    @Scheduled(cron="*/5 * * * * *")
    public void executeView(){
    viewService.viewTopStocks();
    viewService.viewTopCompanies();
    }
}
