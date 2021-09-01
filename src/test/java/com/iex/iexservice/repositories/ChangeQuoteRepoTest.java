package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.ChangeQuoteEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChangeQuoteRepoTest {

    @Autowired
    private ChangeQuoteRepo changeQuoteRepo;

    @Test
    public void test() {
        ChangeQuoteEntity objectToSave = new ChangeQuoteEntity("v1",0.1);
        changeQuoteRepo.save(objectToSave);
        assertEquals(objectToSave.getChange(),changeQuoteRepo.findById("v1").get().getChange());
    }


    @Test
    public void updateTest(){
        ChangeQuoteEntity objectToSave = new ChangeQuoteEntity("v1",0.1);
        changeQuoteRepo.save(objectToSave);
        objectToSave.setChange(0.2);
        changeQuoteRepo.save(objectToSave);
        assertEquals(0.2,changeQuoteRepo.findById("v1").get().getChange());
    }

    @Test
    public void removeTest(){
        ChangeQuoteEntity objectToSave = new ChangeQuoteEntity("v1",0.1);
        changeQuoteRepo.save(objectToSave);
        changeQuoteRepo.deleteById(objectToSave.getSymbol());
        Optional<ChangeQuoteEntity> objectToSave1 = changeQuoteRepo.findById(objectToSave.getSymbol());
        assertEquals(Optional.empty(),objectToSave1);
    }
}