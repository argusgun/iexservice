package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Symbol {
    @Id
    private String symbol;
    private String name;
    private String exchange;
    private String exchangeSuffix;
    private String exchangeName;
    private String lei;
    private String date;
    private String type;
    private String iexId;
    private String region;
    private String currency;
    private boolean isEnabled;
    private String figi;
    private Long cik;

    @JsonCreator
    public Symbol(@JsonProperty("symbol") String symbol,
                  @JsonProperty("name") String name,
                  @JsonProperty("exchange") String exchange,
                  @JsonProperty("exchangeSuffix") String exchangeSuffix,
                  @JsonProperty("exchangeName") String exchangeName,
                  @JsonProperty("lei") String lei,
                  @JsonProperty("date") String date,
                  @JsonProperty("type") String type,
                  @JsonProperty("iexId") String iexId,
                  @JsonProperty("region") String region,
                  @JsonProperty("currency") String currency,
                  @JsonProperty("isEnabled") boolean isEnabled,
                  @JsonProperty("figi") String figi,
                  @JsonProperty("cik") Long cik) {
        this.symbol = symbol;
        this.name = name;
        this.date = date;
        this.type = type;
        this.iexId = iexId;
        this.region = region;
        this.currency = currency;
        this.isEnabled = isEnabled;
        this.figi = figi;
        this.cik = cik;
        this.exchange = exchange;
        this.exchangeSuffix = exchangeSuffix;
        this.exchangeName = exchangeName;
        this.lei = lei;
    }

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

