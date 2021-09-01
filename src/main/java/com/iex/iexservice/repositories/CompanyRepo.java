package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<CompanyEntity,String> {
}
