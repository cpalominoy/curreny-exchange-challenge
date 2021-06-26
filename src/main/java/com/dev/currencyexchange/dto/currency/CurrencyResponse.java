package com.dev.currencyexchange.dto.currency;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyResponse {

  private Long id;
  private String code;
  private String description;

}
