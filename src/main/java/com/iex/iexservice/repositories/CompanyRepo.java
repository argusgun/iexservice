package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepo extends MongoRepository<Company,String> {
}
