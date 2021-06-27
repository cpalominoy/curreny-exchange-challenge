package com.dev.currencyexchange.respository;

import com.dev.currencyexchange.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface Class for Entity Currency.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {


}
