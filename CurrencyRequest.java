package currency.example.currency.request;

import java.sql.Date;

public class CurrencyRequest {
    private String currencyType;
    private String currencySource;
    private Date currencyTime;

    public String getCurrencyType() {
        return currencyType;
    }

    public CurrencyRequest(String currencyType, String currencySource, Date currencyTime) {
        this.currencyType = currencyType;
        this.currencySource = currencySource;
        this.currencyTime = currencyTime;
    }

    public CurrencyRequest() {
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getCurrencySource() {
        return currencySource;
    }

    public void setCurrencySource(String currencySource) {
        this.currencySource = currencySource;
    }

    public Date getCurrencyTime() {
        return currencyTime;
    }

    public void setCurrencyTime(Date currencyTime) {
        this.currencyTime = currencyTime;
    }
}
