package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.entity.CurrencyEntity;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ExchangeRateMapper DTO - Entity.
 */
@Slf4j
@Component
public class ExchangeRateMapper {

  /**
   * Method ExchangeRateEntity to DTO.
   *
   * @param entity ExchangeRateEntity
   * @return ExchangeRateResponse
   */
  public ExchangeRateResponse toResponseDto(ExchangeRateEntity entity) {
    CurrencyResponse sourceCurrency = CurrencyResponse.builder()
        .id(entity.getSourceCurrencyEntity().getId())
        .code(entity.getSourceCurrencyEntity().getCode())
        .description(entity.getSourceCurrencyEntity().getDescription())
        .build();

    CurrencyResponse targetCurrency = CurrencyResponse.builder()
        .id(entity.getTargetCurrencyEntity().getId())
        .code(entity.getTargetCurrencyEntity().getCode())
        .description(entity.getTargetCurrencyEntity().getDescription())
        .build();

    return ExchangeRateResponse.builder()
        .id(entity.getId())
        .sourceCurrency(sourceCurrency)
        .targetCurrency(targetCurrency)
        .rate(entity.getRate()).build();
  }

  /**
   * Method ExchangeRateRequest to Entity.
   *
   * @param request ExchangeRateRequest
   * @param source  CurrencyEntity
   * @param target  CurrencyEntity
   * @return ExchangeRateEntity
   */
  public ExchangeRateEntity toEntity(ExchangeRateRequest request, CurrencyEntity source,
      CurrencyEntity target) {

    return ExchangeRateEntity.builder()
        .rate(request.getRate())
        .sourceCurrencyEntity(source)
        .targetCurrencyEntity(target)
        .build();


  }

  /**
   * Method ExchangeRateRequest to Entity.
   *
   * @param request ExchangeRateRequest
   * @param source  CurrencyEntity
   * @param target  CurrencyEntity
   * @param id      ExchangeRateId
   * @return ExchangeRateEntity
   */
  public ExchangeRateEntity toEntity(ExchangeRateRequest request, CurrencyEntity source,
      CurrencyEntity target, Long id) {

    return ExchangeRateEntity.builder()
        .id(id)
        .rate(request.getRate())
        .sourceCurrencyEntity(source)
        .targetCurrencyEntity(target)
        .build();
  }


}
