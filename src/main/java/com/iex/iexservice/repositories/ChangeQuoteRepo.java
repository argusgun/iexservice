package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.ChangeQuoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeQuoteRepo extends MongoRepository<ChangeQuoteEntity,String> {
}
