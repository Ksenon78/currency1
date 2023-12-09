package currency.example.currency.mapper;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.response.CurrencyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CurrencyResponseMapper {

    @Mapping(target = "quotes", source ="quotes" ,qualifiedByName  = "toStringMap")
    CurrencyResponse toResponse(CurrencyEntity entity);
    @Named("toStringMap")
    default String toStringMap(Map<String, Double> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(","));
    }

}
