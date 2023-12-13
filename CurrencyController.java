package currency.example.currency.controller;

import currency.example.currency.response.CurrencyResponse;
import currency.example.currency.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currency/")
    public List<CurrencyResponse> getCurrency(@RequestParam("currencyType") String currencyType,
                                                  @RequestParam("currencySource") String currencySource,
                                                  @RequestParam("currencyTime") LocalDate currencyTime) {
        return currencyService.findAllCurrency(currencyType, currencySource, currencyTime);

    }
}
