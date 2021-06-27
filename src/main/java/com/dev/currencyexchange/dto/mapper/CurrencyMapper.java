package com.dev.currencyexchange.dto.mapper;

import com.dev.currencyexchange.dto.currency.CurrencyRequest;
import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.entity.CurrencyEntity;
import org.springframework.stereotype.Component;


/**
 * CurrencyMapper DTO - Entity.
 */
@Component
public class CurrencyMapper {

  /**
   * Method convert CurrencyEntity to DTO.
   *
   * @param entity CurrencyEntity
   * @return CurrencyResponse
   */
  public CurrencyResponse toResponseDto(CurrencyEntity entity) {
    return CurrencyResponse.builder()
        .id(entity.getId())
        .code(entity.getCode())
        .description(entity.getDescription())
        .build();
  }


  /**
   * Method CurrencyRequest CurrencyEntity to DTO.
   *
   * @param request CurrencyRequest
   * @return CurrencyEntity
   */
  public CurrencyEntity toEntity(CurrencyRequest request) {
    return CurrencyEntity.builder()
        .code(request.getCode())
        .description(request.getDescription())
        .build();
  }


}
