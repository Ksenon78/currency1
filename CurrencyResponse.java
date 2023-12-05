package currency.example.currency.response;

import java.sql.Date;
import java.util.Map;

public class CurrencyResponse {
    private String currencySource;
    private Date timestamp;
    private String currencyType;
    private Map<String, Double> quotes;
    public CurrencyResponse() {
    }
    public CurrencyResponse(String currencySource, Date timestamp, String currencyType, Map<String, Double> quotes) {
        this.currencySource = currencySource;
        this.timestamp = timestamp;
        this.currencyType = currencyType;
        this.quotes = quotes;
    }

    public String getCurrencySource() {
        return currencySource;
    }

    public void setCurrencySource(String currencySource) {
        this.currencySource = currencySource;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Double> quotes) {
        this.quotes = quotes;
    }
}
