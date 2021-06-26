package com.dev.currencyexchange.dto.exchange;

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
  private String source;

  /**
   * moneda destino
   */
  private String target;

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
