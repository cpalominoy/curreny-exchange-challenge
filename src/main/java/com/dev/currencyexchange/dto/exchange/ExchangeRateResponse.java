package com.dev.currencyexchange.dto.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class ExchangeRateResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("source")
  private String sourceCurrency;

  @JsonProperty("target")
  private String targetCurrency;

  @JsonProperty("rate")
  private BigDecimal rate;

}
