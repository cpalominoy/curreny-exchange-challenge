package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.entity.CurrencyEntity;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

  public CurrencyResponse toResponseDto(CurrencyEntity entity) {
    return CurrencyResponse.builder()
        .id(entity.getId())
        .code(entity.getCode())
        .description(entity.getDescription())
        .build();
  }

}
