package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.List;

@Data
public class Symbols {
    @JsonBackReference
    public List<Symbol> symbols;

    @JsonCreator
    public Symbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}
