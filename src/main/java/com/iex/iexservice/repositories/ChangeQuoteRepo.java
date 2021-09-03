package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.ChangeQuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeQuoteRepo extends JpaRepository<ChangeQuoteEntity,String> {
}
