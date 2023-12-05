package currency.example.currency.service;

import currency.example.currency.response.CurrencyResponse;

import java.sql.Date;
import java.util.List;

public interface CurrencyService {
    List<CurrencyResponse> findAllCurrency(String currencyType, String currencySource, Date currencyTime);
}
