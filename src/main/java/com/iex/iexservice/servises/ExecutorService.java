package com.iex.iexservice.servises;


import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import com.iex.iexservice.repositories.SymbolRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ExecutorService {

    @Autowired
    QuoteRepo quoteRepo;
    @Autowired
    SymbolRepo symbolRepo;
    @Autowired
    CompanyRepo companyRepo;

}
