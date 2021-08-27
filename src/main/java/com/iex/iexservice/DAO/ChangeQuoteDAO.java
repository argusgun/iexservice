package com.iex.iexservice.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "changequote")
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
