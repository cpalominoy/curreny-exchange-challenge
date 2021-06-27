package com.dev.currencyexchange.respository;

import com.dev.currencyexchange.entity.ExchangeRateEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface Class for Entity Currency.
 */
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateEntity, Long> {

  @Query("from ExchangeRateEntity e "
      + "where "
      + "e.sourceCurrencyEntity.code=:source "
      + "and "
      + "e.targetCurrencyEntity.code=:target ")
  Optional<ExchangeRateEntity> findRateByCurrency(
      @Param("source") String source, @Param("target") String target);

  Optional<ExchangeRateEntity> findBySourceCurrencyEntity_IdAndTargetCurrencyEntity_Id(
      Long sourceId, Long targetId);


}
