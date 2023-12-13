package currency.example.currency.outbondhandler;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.mapper.CurrencyMapper;
import currency.example.currency.repository.CurrencyRepository;
import currency.example.currency.outbound.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyHandlerService {

    private final CurrencyMapper currencyMapper;

    private final CurrencyRepository currencyRepository;


    @Value("${currencylayer.api.key}")
    private String apiKey;

    public CurrencyHandlerService(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
        this.currencyMapper = currencyMapper;
        this.currencyRepository = currencyRepository;

    }

    @Scheduled(fixedRate = 100000)
    public void fetchAndSaveCurrencyRatesScheduled() {
        fetchDataAndSaveToDatabase();

    }

    public void fetchDataAndSaveToDatabase() {

        String apiUrlUsd = "http://apilayer.net/api/live?access_key=eaa4b7eb2120914faa950bfbf3438c4b&currencies=EUR,GBP,CAD,PL&source=USD&format=1";
        String apiUrlEur = "http://apilayer.net/api/live?access_key=eaa4b7eb2120914faa950bfbf3438c4b&currencies=USD,GBP,CAD,PL,TRY&source=EUR&format=1";

        RestTemplate restTemplateUsd = new RestTemplate();

        CurrencyApiResponse responseUsd = restTemplateUsd.getForObject(apiUrlUsd, CurrencyApiResponse.class);
        CurrencyApiResponse responseEur = restTemplateUsd.getForObject(apiUrlEur, CurrencyApiResponse.class);
        List<CurrencyEntity> currencyEntityList = new ArrayList<>();
        currencyEntityList.add(currencyMapper.toEntity(responseUsd));
        currencyEntityList.add(currencyMapper.toEntity(responseEur));




        currencyRepository.saveAll(currencyEntityList);

    }


}
