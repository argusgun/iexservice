package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.QuoteDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuoteRepo extends MongoRepository<QuoteDAO,String> {
    Optional<QuoteDAO> findById(String s);
}
