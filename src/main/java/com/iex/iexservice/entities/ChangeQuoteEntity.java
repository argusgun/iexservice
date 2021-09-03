package com.iex.iexservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ChangeQuoteEntity {
    @Id
    private String symbol;
    private Double change;

    public ChangeQuoteEntity() {
    }

    public ChangeQuoteEntity(String symbol, Double change) {
        this.symbol = symbol;
        this.change = change;
    }
}
