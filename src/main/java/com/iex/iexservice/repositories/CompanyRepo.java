package com.iex.iexservice.repositories;

import com.iex.iexservice.DAO.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<CompanyEntity,String> {
}
