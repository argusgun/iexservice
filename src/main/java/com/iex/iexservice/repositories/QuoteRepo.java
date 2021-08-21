package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuoteRepo extends MongoRepository<Quote,String> {
    Optional<Quote> findById(String s);
}
