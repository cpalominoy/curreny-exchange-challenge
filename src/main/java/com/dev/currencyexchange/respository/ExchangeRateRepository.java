package com.dev.currencyexchange.respository;

import com.dev.currencyexchange.entity.ExchangeRateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

  Optional<ExchangeRateEntity> findExchangeRateEntityBySourceCurrencyAndTargetCurrency(
      String sourceCurrency,
      String targetCurrency);

}
