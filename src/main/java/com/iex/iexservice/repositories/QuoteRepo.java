package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.QuoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuoteRepo extends MongoRepository<QuoteEntity,String> {
    Optional<QuoteEntity> findById(String s);
}
