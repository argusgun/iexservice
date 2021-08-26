package com.iex.iexservice.DAO;

import com.iex.iexservice.entities.Quote;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class QuoteDAO {
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

    public QuoteDAO(String symbol, String companyName, String primaryExchange, String calculationPrice, Double open, Long openTime, String openSource, Double close, Long closeTime, String closeSource, Double high, Long highTime, String highSource, Double low, Long lowTime, String lowSource, Double latestPrice, String latestSource, String latestTime, Long latestUpdate, Long latestVolume, Double iexRealtimePrice, Long iexRealtimeSize, Long iexLastUpdated, Double delayedPrice, Long delayedPriceTime, Double oddLotDelayedPrice, Long oddLotDelayedPriceTime, Double extendedPrice, Double extendedChange, Double extendedChangePercent, Long extendedPriceTime, Double previousClose, Long previousVolume, Double change, Double changePercent, Long volume, Double iexMarketPercent, Long iexVolume, Long avgTotalVolume, Double iexBidPrice, Long iexBidSize, Double iexAskPrice, Long iexAskSize, Double iexOpen, Long iexOpenTime, Double iexClose, Long iexCloseTime, Long marketCap, Double peRatio, Double week52High, Double week52Low, Double ytdChange, Long lastTradeTime, String currency, boolean isUSMarketOpen) {
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

    public static QuoteDAO fromEntityToDAO(Quote quote){
        QuoteDAO dao =new QuoteDAO();
        dao.symbol = quote.getSymbol();
        dao.companyName = quote.getCompanyName();
        dao.primaryExchange = quote.getPrimaryExchange();
        dao.calculationPrice = quote.getCalculationPrice();
        dao.open = quote.getOpen();
        dao.openTime = quote.getOpenTime();
        dao.openSource = quote.getOpenSource();
        dao.close = quote.getClose();
        dao.closeTime = quote.getCloseTime();
        dao.closeSource = quote.getCloseSource();
        dao.high = quote.getHigh();
        dao.highTime = quote.getHighTime();
        dao.highSource = quote.getHighSource();
        dao.low = quote.getLow();
        dao.lowTime = quote.getLowTime();
        dao.lowSource = quote.getLowSource();
        dao.latestPrice = quote.getLatestPrice();
        dao.latestSource = quote.getLatestSource();
        dao.latestTime = quote.getLatestTime();
        dao.latestUpdate = quote.getLatestUpdate();
        dao.latestVolume = quote.getLatestVolume();
        dao.iexRealtimePrice = quote.getIexRealtimePrice();
        dao.iexRealtimeSize = quote.getIexRealtimeSize();
        dao.iexLastUpdated = quote.getIexLastUpdated();
        dao.delayedPrice = quote.getDelayedPrice();
        dao.delayedPriceTime = quote.getDelayedPriceTime();
        dao.oddLotDelayedPrice = quote.getOddLotDelayedPrice();
        dao.oddLotDelayedPriceTime = quote.getOddLotDelayedPriceTime();
        dao.extendedPrice = quote.getExtendedPrice();
        dao.extendedChange = quote.getExtendedChange();
        dao.extendedChangePercent = quote.getExtendedChangePercent();
        dao.extendedPriceTime = quote.getExtendedPriceTime();
        dao.previousClose = quote.getPreviousClose();
        dao.previousVolume = quote.getPreviousVolume();
        dao.change = quote.getChange();
        dao.changePercent = quote.getChangePercent();
        dao.volume = quote.getVolume();
        dao.iexMarketPercent = quote.getIexMarketPercent();
        dao.iexVolume = quote.getIexVolume();
        dao.avgTotalVolume = quote.getAvgTotalVolume();
        dao.iexBidPrice = quote.getIexBidPrice();
        dao.iexBidSize = quote.getIexBidSize();
        dao.iexAskPrice = quote.getIexAskPrice();
        dao.iexAskSize = quote.getIexAskSize();
        dao.iexOpen = quote.getIexOpen();
        dao.iexOpenTime = quote.getIexOpenTime();
        dao.iexClose = quote.getIexClose();
        dao.iexCloseTime = quote.getIexCloseTime();
        dao.marketCap = quote.getMarketCap();
        dao.peRatio = quote.getPeRatio();
        dao.week52High = quote.getWeek52High();
        dao.week52Low = quote.getWeek52Low();
        dao.ytdChange = quote.getYtdChange();
        dao.lastTradeTime = quote.getLastTradeTime();
        dao.currency = quote.getCurrency();
        dao.isUSMarketOpen = quote.isUSMarketOpen();
        return dao;
    }

    public QuoteDAO() {

    }

    public Quote toEntity(){
        return new Quote(symbol,
                companyName,
                primaryExchange,
                calculationPrice,
                open,
                openTime,
                openSource,
                close,
                closeTime,
                closeSource,
                high,
                highTime,
                highSource,
                low,
                lowTime,
                lowSource,
                latestPrice,
                latestSource,
                latestTime,
                latestUpdate,
                latestVolume,
                iexRealtimePrice,
                iexRealtimeSize,
                iexLastUpdated,
                delayedPrice,
                delayedPriceTime,
                oddLotDelayedPrice,
                oddLotDelayedPriceTime,
                extendedPrice,
                extendedChange,
                extendedChangePercent,
                extendedPriceTime,
                previousClose,
                previousVolume,
                change,
                changePercent,
                volume,
                iexMarketPercent,
                iexVolume,
                avgTotalVolume,
                iexBidPrice,
                iexBidSize,
                iexAskPrice,
                iexAskSize,
                iexOpen,
                iexOpenTime,
                iexClose,
                iexCloseTime,
                marketCap,
                peRatio,
                week52High,
                week52Low,
                ytdChange,
                lastTradeTime,
                currency,
                isUSMarketOpen);
    }
}
