package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Quote {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("primaryExchange")
    private String primaryExchange;
    @JsonProperty("calculationPrice")
    private String calculationPrice;
    @JsonProperty("open")
    private Double open;
    @JsonProperty("openTime")
    private Long openTime;
    @JsonProperty("openSource")
    private String openSource;
    @JsonProperty("close")
    private Double close;
    @JsonProperty("closeTime")
    private Long closeTime;
    @JsonProperty("closeSource")
    private String closeSource;
    @JsonProperty("high")
    private Double high;
    @JsonProperty("highTime")
    private Long highTime;
    @JsonProperty("highSource")
    private String highSource;
    @JsonProperty("low")
    private Double low;
    @JsonProperty("lowTime")
    private Long lowTime;
    @JsonProperty("lowSource")
    private String lowSource;
    @JsonProperty("latestPrice")
    private Double latestPrice;
    @JsonProperty("latestSource")
    private String latestSource;
    @JsonProperty("latestTime")
    private String latestTime;
    @JsonProperty("latestUpdate")
    private Long latestUpdate;
    @JsonProperty("latestVolume")
    private Long latestVolume;
    @JsonProperty("iexRealtimePrice")
    private Double iexRealtimePrice;
    @JsonProperty("iexRealtimeSize")
    private Long iexRealtimeSize;
    @JsonProperty("iexLastUpdated")
    private Long iexLastUpdated;
    @JsonProperty("delayedPrice")
    private Double delayedPrice;
    @JsonProperty("delayedPriceTime")
    private Long delayedPriceTime;
    @JsonProperty("oddLotDelayedPrice")
    private Double oddLotDelayedPrice;
    @JsonProperty("oddLotDelayedPriceTime")
    private Long oddLotDelayedPriceTime;
    @JsonProperty("extendedPrice")
    private Double extendedPrice;
    @JsonProperty("extendedChange")
    private Double extendedChange;
    @JsonProperty("extendedChangePercent")
    private Double extendedChangePercent;
    @JsonProperty("extendedPriceTime")
    private Long extendedPriceTime;
    @JsonProperty("previousClose")
    private Double previousClose;
    @JsonProperty("previousVolume")
    private Long previousVolume;
    @JsonProperty("change")
    private Double change;
    @JsonProperty("changePercent")
    private Double changePercent;
    @JsonProperty("volume")
    private Long volume;
    @JsonProperty("iexMarketPercent")
    private Double iexMarketPercent;
    @JsonProperty("iexVolume")
    private Long iexVolume;
    @JsonProperty("avgTotalVolume")
    private Long avgTotalVolume;
    @JsonProperty("iexBidPrice")
    private Double iexBidPrice;
    @JsonProperty("iexBidSize")
    private Long iexBidSize;
    @JsonProperty("iexAskPrice")
    private Double iexAskPrice;
    @JsonProperty("iexAskSize")
    private Long iexAskSize;
    @JsonProperty("iexOpen")
    private Double iexOpen;
    @JsonProperty("iexOpenTime")
    private Long iexOpenTime;
    @JsonProperty("iexClose")
    private Double iexClose;
    @JsonProperty("iexCloseTime")
    private Long iexCloseTime;
    @JsonProperty("marketCap")
    private Long marketCap;
    @JsonProperty("peRatio")
    private Double peRatio;
    @JsonProperty("week52High")
    private Double week52High;
    @JsonProperty("week52Low")
    private Double week52Low;
    @JsonProperty("ytdChange")
    private Double ytdChange;
    @JsonProperty("lastTradeTime")
    private Long lastTradeTime;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isUSMarketOpen")
    private boolean isUSMarketOpen;

    public Quote(String symbol, String companyName, String primaryExchange, String calculationPrice, Double open, Long openTime, String openSource, Double close, Long closeTime, String closeSource, Double high, Long highTime, String highSource, Double low, Long lowTime, String lowSource, Double latestPrice, String latestSource, String latestTime, Long latestUpdate, Long latestVolume, Double iexRealtimePrice, Long iexRealtimeSize, Long iexLastUpdated, Double delayedPrice, Long delayedPriceTime, Double oddLotDelayedPrice, Long oddLotDelayedPriceTime, Double extendedPrice, Double extendedChange, Double extendedChangePercent, Long extendedPriceTime, Double previousClose, Long previousVolume, Double change, Double changePercent, Long volume, Double iexMarketPercent, Long iexVolume, Long avgTotalVolume, Double iexBidPrice, Long iexBidSize, Double iexAskPrice, Long iexAskSize, Double iexOpen, Long iexOpenTime, Double iexClose, Long iexCloseTime, Long marketCap, Double peRatio, Double week52High, Double week52Low, Double ytdChange, Long lastTradeTime, String currency, boolean isUSMarketOpen) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.primaryExchange = primaryExchange;
        this.calculationPrice = calculationPrice;
        this.open = open;
        this.openTime = openTime;
        this.openSource = openSource;
        this.close = close;
        this.closeTime = closeTime;
        this.closeSource = closeSource;
        this.high = high;
        this.highTime = highTime;
        this.highSource = highSource;
        this.low = low;
        this.lowTime = lowTime;
        this.lowSource = lowSource;
        this.latestPrice = latestPrice;
        this.latestSource = latestSource;
        this.latestTime = latestTime;
        this.latestUpdate = latestUpdate;
        this.latestVolume = latestVolume;
        this.iexRealtimePrice = iexRealtimePrice;
        this.iexRealtimeSize = iexRealtimeSize;
        this.iexLastUpdated = iexLastUpdated;
        this.delayedPrice = delayedPrice;
        this.delayedPriceTime = delayedPriceTime;
        this.oddLotDelayedPrice = oddLotDelayedPrice;
        this.oddLotDelayedPriceTime = oddLotDelayedPriceTime;
        this.extendedPrice = extendedPrice;
        this.extendedChange = extendedChange;
        this.extendedChangePercent = extendedChangePercent;
        this.extendedPriceTime = extendedPriceTime;
        this.previousClose = previousClose;
        this.previousVolume = previousVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.volume = volume;
        this.iexMarketPercent = iexMarketPercent;
        this.iexVolume = iexVolume;
        this.avgTotalVolume = avgTotalVolume;
        this.iexBidPrice = iexBidPrice;
        this.iexBidSize = iexBidSize;
        this.iexAskPrice = iexAskPrice;
        this.iexAskSize = iexAskSize;
        this.iexOpen = iexOpen;
        this.iexOpenTime = iexOpenTime;
        this.iexClose = iexClose;
        this.iexCloseTime = iexCloseTime;
        this.marketCap = marketCap;
        this.peRatio = peRatio;
        this.week52High = week52High;
        this.week52Low = week52Low;
        this.ytdChange = ytdChange;
        this.lastTradeTime = lastTradeTime;
        this.currency = currency;
        this.isUSMarketOpen = isUSMarketOpen;
    }
}
