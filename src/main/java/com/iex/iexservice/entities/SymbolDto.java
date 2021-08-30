package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SymbolDto {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("exchangeSuffix")
    private String exchangeSuffix;
    @JsonProperty("exchangeName")
    private String exchangeName;
    @JsonProperty("lei")
    private String lei;
    @JsonProperty("date")
    private String date;
    @JsonProperty("type")
    private String type;
    @JsonProperty("iexId")
    private String iexId;
    @JsonProperty("region")
    private String region;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isEnabled")
    private boolean isEnabled;
    @JsonProperty("figi")
    private String figi;
    @JsonProperty("cik")
    private Long cik;

    @Override
    public String toString() {
        return "Symbol{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", exchange='" + exchange + '\'' +
                ", exchangeSuffix='" + exchangeSuffix + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", lei='" + lei + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", iexId='" + iexId + '\'' +
                ", region='" + region + '\'' +
                ", currency='" + currency + '\'' +
                ", isEnabled=" + isEnabled +
                ", figi='" + figi + '\'' +
                ", cik=" + cik +
                '}';
    }
}

