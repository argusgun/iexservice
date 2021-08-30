package com.iex.iexservice.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "changequote")
@Data
public class ChangeQuoteEntity {
    @Id
    private String symbol;
    private Double change;

    public ChangeQuoteEntity(String symbol, Double change) {
        this.symbol = symbol;
        this.change = change;
    }
}
