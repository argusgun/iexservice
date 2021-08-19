package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@Data
public class Quote {
    @Id
    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String calculationPrice;
    private Double open;
    private Long openTime;
    private String openSource;
    private Double close;
    private Long closeTime;
    private String closeSource;
    private Double high;
    private Long highTime;
    private String highSource;
    private Double low;
    private Long lowTime;
    private String lowSource;
    private Double latestPrice;
    private String latestSource;
    private String latestTime;
    private Long latestUpdate;
    private Long latestVolume;
    private Double iexRealtimePrice;
    private Long iexRealtimeSize;
    private Long iexLastUpdated;
    private Double delayedPrice;
    private Long delayedPriceTime;
    private Double oddLotDelayedPrice;
    private Long oddLotDelayedPriceTime;
    private Double extendedPrice;
    private Double extendedChange;
    private Double extendedChangePercent;
    private Long extendedPriceTime;
    private Double previousClose;
    private Long previousVolume;
    private Double change;
    private Double changePercent;
    private Long volume;
    private Double iexMarketPercent;
    private Long iexVolume;
    private Long avgTotalVolume;
    private Double iexBidPrice;
    private Long iexBidSize;
    private Double iexAskPrice;
    private Long iexAskSize;
    private Double iexOpen;
    private Long iexOpenTime;
    private Double iexClose;
    private Long iexCloseTime;
    private Long marketCap;
    private Double peRatio;
    private Double week52High;
    private Double week52Low;
    private Double ytdChange;
    private Long lastTradeTime;
    private String currency;
    private boolean isUSMarketOpen;

    @JsonCreator

    public Quote(@JsonProperty("symbol") String symbol,
                 @JsonProperty("companyName")String companyName,
                 @JsonProperty("primaryExchange")String primaryExchange,
                 @JsonProperty("calculationPrice")String calculationPrice,
                 @JsonProperty("open")Double open,
                 @JsonProperty("openTime")Long openTime,
                 @JsonProperty("openSource")String openSource,
                 @JsonProperty("close")Double close,
                 @JsonProperty("closeTime")Long closeTime,
                 @JsonProperty("closeSource")String closeSource,
                 @JsonProperty("high")Double high,
                 @JsonProperty("highTime")Long highTime,
                 @JsonProperty("highSource")String highSource,
                 @JsonProperty("low")Double low,
                 @JsonProperty("lowTime")Long lowTime,
                 @JsonProperty("lowSource")String lowSource,
                 @JsonProperty("latestPrice")Double latestPrice,
                 @JsonProperty("latestSource")String latestSource,
                 @JsonProperty("latestTime")String latestTime,
                 @JsonProperty("latestUpdate")Long latestUpdate,
                 @JsonProperty("latestVolume")Long latestVolume,
                 @JsonProperty("iexRealtimePrice")Double iexRealtimePrice,
                 @JsonProperty("iexRealtimeSize")Long iexRealtimeSize,
                 @JsonProperty("iexLastUpdated")Long iexLastUpdated,
                 @JsonProperty("delayedPrice")Double delayedPrice,
                 @JsonProperty("delayedPriceTime")Long delayedPriceTime,
                 @JsonProperty("oddLotDelayedPrice")Double oddLotDelayedPrice,
                 @JsonProperty("oddLotDelayedPriceTime")Long oddLotDelayedPriceTime,
                 @JsonProperty("extendedPrice")Double extendedPrice,
                 @JsonProperty("extendedChange")Double extendedChange,
                 @JsonProperty("extendedChangePercent")Double extendedChangePercent,
                 @JsonProperty("extendedPriceTime")Long extendedPriceTime,
                 @JsonProperty("previousClose")Double previousClose,
                 @JsonProperty("previousVolume")Long previousVolume,
                 @JsonProperty("change")Double change,
                 @JsonProperty("changePercent")Double changePercent,
                 @JsonProperty("volume")Long volume,
                 @JsonProperty("iexMarketPercent")Double iexMarketPercent,
                 @JsonProperty("iexVolume")Long iexVolume,
                 @JsonProperty("avgTotalVolume")Long avgTotalVolume,
                 @JsonProperty("iexBidPrice")Double iexBidPrice,
                 @JsonProperty("iexBidSize")Long iexBidSize,
                 @JsonProperty("iexAskPrice")Double iexAskPrice,
                 @JsonProperty("iexAskSize")Long iexAskSize,
                 @JsonProperty("iexOpen")Double iexOpen,
                 @JsonProperty("iexOpenTime")Long iexOpenTime,
                 @JsonProperty("iexClose")Double iexClose,
                 @JsonProperty("iexCloseTime")Long iexCloseTime,
                 @JsonProperty("marketCap")Long marketCap,
                 @JsonProperty("peRatio")Double peRatio,
                 @JsonProperty("week52High")Double week52High,
                 @JsonProperty("week52Low")Double week52Low,
                 @JsonProperty("ytdChange")Double ytdChange,
                 @JsonProperty("lastTradeTime")Long lastTradeTime,
                 @JsonProperty("currency")String currency,
                 @JsonProperty("isUSMarketOpen")boolean isUSMarketOpen) {
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
