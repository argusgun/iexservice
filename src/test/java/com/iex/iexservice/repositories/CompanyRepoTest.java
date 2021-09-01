package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.CompanyEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CompanyRepoTest {

    @Autowired
    private CompanyRepo companyRepo;

    @Test
    public void test() {
        CompanyEntity objectToSave = new CompanyEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        companyRepo.save(objectToSave);
        assertEquals(objectToSave.getCompanyName(),companyRepo.findById("CompanyTest").get().getCompanyName());
    }


    @Test
    public void updateTest(){
        CompanyEntity objectToSave = new CompanyEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        companyRepo.save(objectToSave);
        objectToSave.setCompanyName("NameUpdated");
        companyRepo.save(objectToSave);
        assertEquals("NameUpdated",companyRepo.findById("CompanyTest").get().getCompanyName());
    }

    @Test
    public void removeTest(){
        CompanyEntity objectToSave = new CompanyEntity();
        objectToSave.setSymbol("CompanyTest");
        objectToSave.setCompanyName("Name");
        companyRepo.save(objectToSave);
        companyRepo.deleteById(objectToSave.getSymbol());
        Optional<CompanyEntity> objectToSave1 = companyRepo.findById(objectToSave.getSymbol());
        assertEquals(Optional.empty(),objectToSave1);
    }
}