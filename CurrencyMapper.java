package currency.example.currency.mapper;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.outbound.CurrencyApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    @Mapping(target = "quotes", source ="quotes",qualifiedByName  = "mapToString")
    CurrencyEntity toEntity(CurrencyApiResponse response);
    @Named("mapToString")
    default String mapToString(Map<String, Double> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(","));
    }

}
