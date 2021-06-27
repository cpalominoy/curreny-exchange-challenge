package com.dev.currencyexchange.dto.exchange;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * CurrencyExchangeRateRequest class that represents a data presentation model that will be exposed
 * by the api for the body of each request.
 */
@Getter
@Setter
public class CurrencyExchangeRateRequest {

  /**
   * moneda origen.
   */
  @NotNull
  @NotBlank(message = "source cannot be null")
  private String source;

  /**
   * moneda destino.
   */
  @NotNull
  @NotBlank(message = "target cannot be null")
  private String target;

  /**
   * monto original.
   */
  @DecimalMin(value = "0.0", inclusive = false)
  @NotNull(message = "amount cannot be null")
  private BigDecimal amount;
}
