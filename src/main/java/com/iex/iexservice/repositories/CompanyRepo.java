package com.iex.iexservice.repositories;

import com.iex.iexservice.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyEntity,String> {
}
