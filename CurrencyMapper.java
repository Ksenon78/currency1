package currency.example.currency.mapper;

import currency.example.currency.entity.CurrencyEntity;
import currency.example.currency.outbound.CurrencyApiResponse;
import currency.example.currency.response.CurrencyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    @Mapping(target = "quotes", source = "quotes", qualifiedByName = "mapToString")
    CurrencyEntity toEntity(CurrencyApiResponse response);

    @Mapping(target = "currencySource", source = "terms")
    @Mapping(target = "currencyType", source = "source")
    @Mapping(target = "quotes", source = "quotes", qualifiedByName = "stringToMap")
    CurrencyResponse toResponse(CurrencyEntity entity);


    @Named("mapToString")
    default String mapToString(Map<String, Double> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(","));
    }


    @Named("stringToMap")
    default Map<String, Double> stringToMap(String input) {
        Map<String, Double> result = new HashMap<>();
        String[] keyValuePairs = input.split(",");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0];
            Double value = Double.parseDouble(keyValue[1]);
            result.put(key, value);
        }
        return result;
    }

}
