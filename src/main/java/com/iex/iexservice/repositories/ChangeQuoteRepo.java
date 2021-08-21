package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.ChangeQuote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeQuoteRepo extends MongoRepository<ChangeQuote,String> {
}
