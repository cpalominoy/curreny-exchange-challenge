package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExchangeRateMapper {

  public ExchangeRateResponse toResponseDto(ExchangeRateEntity entity) {
    return ExchangeRateResponse.builder()
        .id(entity.getId())
        .sourceCurrency(entity.getSourceCurrencyEntity().getCode())
        .targetCurrency(entity.getTargetCurrencyEntity().getCode())
        .rate(entity.getRate()).build();
  }
}
