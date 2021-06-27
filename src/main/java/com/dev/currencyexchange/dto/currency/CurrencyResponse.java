package com.dev.currencyexchange.dto.currency;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * CurrencyResponse class that represents a data presentation model that will be exposed by the api
 * for the response of each request.
 */
@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyResponse {

  private Long id;
  private String code;
  private String description;

}
