package currency.example.currency.repository;

import currency.example.currency.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
    List<CurrencyEntity> findAllByPrivacyAndTimestampAndSource(String privacy, Date timestamp, String source);

    List<CurrencyEntity> findAllByTimestamp(Date timestamp);

    List<CurrencyEntity> findAllBySource(String source);

    List<CurrencyEntity> findAllByPrivacy(String privacy);

}
