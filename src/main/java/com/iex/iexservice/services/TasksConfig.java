package com.iex.iexservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TasksConfig {
    private final MyExecutorService executorService;
    private final ViewService viewService;
    private final Environment environment;


    @Autowired
    public TasksConfig(Environment environment,MyExecutorService executorService, ViewService viewService) {
        this.executorService = executorService;
        this.viewService = viewService;
        this.environment = environment;
    }

    @Scheduled(fixedDelayString = "${f_delay}")
    public void executeAppService() {
        executorService.execute();
    }

    @Scheduled(cron = "${crontask}")
    public void executeView() {

        viewService.viewTopStocks();
        viewService.viewTopCompanies();
    }
}
