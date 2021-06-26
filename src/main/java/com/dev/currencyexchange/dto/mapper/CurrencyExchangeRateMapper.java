package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeRateMapper {

  public CurrencyExchangeRateResponse toGenerateDto(ExchangeRateEntity entity,
      BigDecimal amountRequest) {

    return CurrencyExchangeRateResponse.builder()
        .source(entity.getSourceCurrencyEntity().getCode())
        .target(entity.getTargetCurrencyEntity().getCode())
        .rate(entity.getRate())
        .baseAmount(amountRequest)
        .convertedAmount(amountRequest.multiply(entity.getRate()))
        .build();

  }
}
