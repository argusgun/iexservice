package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.CompanyDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<CompanyDAO,String> {
}
