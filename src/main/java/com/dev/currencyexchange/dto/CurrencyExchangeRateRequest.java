package com.dev.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyExchangeRateRequest {

  /**
   * moneda origen.
   */
  @JsonProperty("source")
  private String sourceCurrency;

  /**
   * moneda destino
   */
  @JsonProperty("target")
  private String targetCurrency;

  /**
   * monto original
   */
  @JsonProperty("amount")
  private BigDecimal amount;
}
