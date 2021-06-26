package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeRateMapper {

  public CurrencyExchangeRateResponse toGenerateDto(ExchangeRateEntity entity,
      BigDecimal amountRequest) {

    return CurrencyExchangeRateResponse.builder()
        .sourceCurrency(entity.getSourceCurrency())
        .targetCurrency(entity.getTargetCurrency())
        .rate(entity.getRate())
        .baseAmount(amountRequest)
        .convertedAmount(amountRequest.multiply(entity.getRate()))
        .build();

  }
}
