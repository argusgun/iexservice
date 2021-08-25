package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class Symbols {
    @JsonBackReference
    public List<Symbol> symbols;

    @JsonCreator
    public Symbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}
