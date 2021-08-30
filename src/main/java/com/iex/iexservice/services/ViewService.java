package com.iex.iexservice.services;

import com.iex.iexservice.DAO.ChangeQuoteEntity;
import com.iex.iexservice.DAO.CompanyEntity;
import com.iex.iexservice.DAO.QuoteEntity;
import com.iex.iexservice.repositories.ChangeQuoteRepo;
import com.iex.iexservice.repositories.CompanyRepo;
import com.iex.iexservice.repositories.QuoteRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class ViewService {

    private final QuoteRepo quoteRepo;

    private final ChangeQuoteRepo changeQuoteRepo;

    private final CompanyRepo companyRepo;
    private final Logger logger = LoggerFactory.getLogger(ViewService.class);

    @Autowired
    public ViewService(QuoteRepo quoteRepo, ChangeQuoteRepo changeQuoteRepo, CompanyRepo companyRepo) {
        this.quoteRepo = quoteRepo;
        this.changeQuoteRepo = changeQuoteRepo;
        this.companyRepo = companyRepo;
    }


    public void viewTopStocks() {
        List<QuoteEntity> quoteList =new ArrayList<>();
        try {
            quoteList = quoteRepo.findAll(Sort.by(Sort.Direction.DESC, "previousVolume ")).stream()
                    .limit(5)
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info("The top 5 highest value stocks:" + quoteList);
    }

    public void viewTopCompanies() {
        List<CompanyEntity>  companyList=new ArrayList<>();
        try {
            List<ChangeQuoteEntity> changeQuoteEntityList =changeQuoteRepo.findAll(Sort.by(Sort.Direction.DESC, "change")).stream()
                    .limit(5)
                    .collect(Collectors.toList());
            System.out.println(changeQuoteEntityList);
            companyList = changeQuoteEntityList.stream()
                    .map(p ->{
                        Optional<CompanyEntity> companyDAO=companyRepo.findById(p.getSymbol());
                                if(companyDAO.isPresent())return companyDAO.get();
                                else return null;
                    })
                    .collect(Collectors.toList());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info("The most recent 5 companies that have the greatest change:" + companyList);
    }

}
