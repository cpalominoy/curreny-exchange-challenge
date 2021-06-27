package com.dev.currencyexchange.dto.exchange;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * ExchangeRateResponse class that represents a data presentation model that will be exposed by the
 * api for the response of each request.
 */
@Getter
@Setter
@Builder(toBuilder = true)
public class ExchangeRateResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("source")
  private CurrencyResponse sourceCurrency;

  @JsonProperty("target")
  private CurrencyResponse targetCurrency;

  @JsonProperty("rate")
  private BigDecimal rate;

}
