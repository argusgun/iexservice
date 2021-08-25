package com.iex.iexservice.config;

import com.iex.iexservice.services.MyExecutorService;
import com.iex.iexservice.services.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TasksConfig {
    private final MyExecutorService executorService;
    private final ViewService viewService;

    @Autowired
    public TasksConfig(MyExecutorService executorService, ViewService viewService) {
        this.executorService = executorService;
        this.viewService = viewService;
    }

    @Scheduled(fixedDelay = 1)
    public void executeAppService() {
        executorService.execute();
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void executeView() {
        viewService.viewTopStocks();
        viewService.viewTopCompanies();
    }
}
