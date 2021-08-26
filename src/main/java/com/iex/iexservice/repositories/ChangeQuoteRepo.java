package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.ChangeQuoteDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangeQuoteRepo extends MongoRepository<ChangeQuoteDAO,String> {
}
