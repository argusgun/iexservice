package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.QuoteEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class QuoteRepoTest {

    @Autowired
    private QuoteRepo quoteRepo;

    @Test
    public void test() {
        QuoteEntity objectToSave = new QuoteEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        quoteRepo.save(objectToSave);
        assertEquals(objectToSave.getCompanyName(),quoteRepo.findById("CompanyTest").get().getCompanyName());
    }


    @Test
    public void updateTest(){
        QuoteEntity objectToSave = new QuoteEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        quoteRepo.save(objectToSave);
        objectToSave.setCompanyName("NameUpdated");
        quoteRepo.save(objectToSave);
        assertEquals("NameUpdated",quoteRepo.findById("CompanyTest").get().getCompanyName());
    }

    @Test
    public void removeTest(){
        QuoteEntity objectToSave = new QuoteEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        quoteRepo.save(objectToSave);
        quoteRepo.deleteById(objectToSave.getSymbol());
        Optional<QuoteEntity> objectToSave1 = quoteRepo.findById(objectToSave.getSymbol());
        assertEquals(Optional.empty(),objectToSave1);
    }
}