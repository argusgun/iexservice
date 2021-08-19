package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.Symbol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SymbolRepo extends MongoRepository<Symbol,String> {
}
