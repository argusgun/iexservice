package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompanyRepo extends MongoRepository<Company,String> {
}
