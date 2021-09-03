package com.iex.iexservice.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
public class ChangeQuoteEntity {
    @Id
    private String symbol;
    private Double changePrice;
}
