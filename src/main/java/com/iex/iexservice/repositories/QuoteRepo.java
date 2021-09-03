package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuoteRepo extends JpaRepository<QuoteEntity,String> {
    Optional<QuoteEntity> findById(String s);
}
