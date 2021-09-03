package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.ChangeQuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChangeQuoteRepo extends JpaRepository<ChangeQuoteEntity,String> {
    List<ChangeQuoteEntity> findAllBySymbolIsNotNullOrderByChangePriceDesc();
}
