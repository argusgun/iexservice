package com.iex.iexservice.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ChangeQuoteDAO {
    @Id
    private String symbol;
    private Double change;

    public ChangeQuoteDAO(String symbol, Double change) {
        this.symbol = symbol;
        this.change = change;
    }
}
