package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.Quote;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuoteRepo extends MongoRepository<Quote,String> {

}
