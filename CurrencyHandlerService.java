package currency.example.currency.outbondhandler;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.mapper.CurrencyMapper;
import currency.example.currency.repository.CurrencyRepository;
import currency.example.currency.outbound.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
        //fetchDataAndSaveToDatabase();
        System.out.println("iptal ettin");
    }

    public void fetchDataAndSaveToDatabase() {
        //  String apiUrl = "https://api.currencylayer.com/live?access_key=" + apiKey;
        String apiUrl = "http://apilayer.net/api/live?access_key=eaa4b7eb2120914faa950bfbf3438c4b&currencies=EUR,GBP,CAD,PL&source=USD&format=1";
        RestTemplate restTemplate = new RestTemplate();
        CurrencyApiResponse response = restTemplate.getForObject(apiUrl, CurrencyApiResponse.class);
        CurrencyEntity entity = currencyMapper.toEntity(response);
        currencyRepository.save(entity);
    }

    private void validateResponse(CurrencyApiResponse response) {
        if (response == null) {
            System.out.println("Reponse is null");
            throw new RuntimeException("CurrencyApiResponse is null");
        } else if (response.getSuccess() == false) {
            System.out.println("Resonse status is" + response.getSuccess());
            throw new RuntimeException("Resonse status is" + response.getSuccess());
        }

    }


}
