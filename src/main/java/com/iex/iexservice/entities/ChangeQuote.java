package com.iex.iexservice.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ChangeQuote {
    @Id
    private String symbol;
    private Double change;

    public ChangeQuote(String symbol, Double change) {
        this.symbol = symbol;
        this.change = change;
    }
}
