package com.dev.currencyexchange.dto.exchange;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ExchangeRateRequest class that represents a data presentation model that will be exposed by the
 * api for the body of each request.
 */
@Getter
@Setter
@Builder(toBuilder = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateRequest {

  @Positive
  @NotNull(message = "sourceId cannot be null")
  @JsonProperty("sourceId")
  private Long sourceCurrency;

  @Positive
  @NotNull(message = "targetId cannot be null")
  @JsonProperty("targetId")
  private Long targetCurrency;

  @DecimalMin(value = "0.0", inclusive = false)
  @NotNull(message = "rate cannot be null")
  @JsonProperty("rate")
  private BigDecimal rate;

}
