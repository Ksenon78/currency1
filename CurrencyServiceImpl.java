package currency.example.currency.service.serviceimpl;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.mapper.CurrencyMapper;
import currency.example.currency.repository.CurrencyRepository;
import currency.example.currency.response.CurrencyResponse;
import currency.example.currency.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
    }

    @Override
    public List<CurrencyResponse> findAllCurrency(String currencyType, String currencySource, LocalDate currencyTime) {
        List<CurrencyEntity> allByPrivacyAndTimestampAndSource = currencyRepository.findAllByPrivacyAndTimestampAndSource(currencySource, currencyTime, currencyType);//TODO Hepsi gelirse
        List<CurrencyResponse> list = allByPrivacyAndTimestampAndSource.stream().map(entity -> currencyMapper.toResponse(entity)).toList();
        return list;
    }


}
