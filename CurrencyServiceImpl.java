package currency.example.currency.service.serviceimpl;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.repository.CurrencyRepository;
import currency.example.currency.response.CurrencyResponse;
import currency.example.currency.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyResponse> findAllCurrency(String currencyType, String currencySource, Date currencyTime) {
        List<CurrencyEntity> allByPrivacyAndTimestampAndSource = currencyRepository.findAllByPrivacyAndTimestampAndSource(currencySource, currencyTime, currencyType);//TODO Hepsi gelirse


      return allByPrivacyAndTimestampAndSource.stream()
                .map(currencyResponseMapper::toResponse)
                .collect(Collectors.toList());
    }






}
