package com.dev.currencyexchange.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyExchangeRateResponse {

  /**
   * moneda origen.
   */
  private String sourceCurrency;

  /**
   * moneda destino
   */
  private String targetCurrency;

  /**
   * tipo de cambio
   */
  private BigDecimal rate;

  /**
   * monto original
   */
  private BigDecimal baseAmount;

  /**
   * monto con tipo de cambio
   */
  private BigDecimal convertedAmount;


}
