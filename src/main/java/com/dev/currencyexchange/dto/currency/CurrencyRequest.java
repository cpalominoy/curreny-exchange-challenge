package com.dev.currencyexchange.dto.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * CurrencyRequest class that represents a data presentation model that will be exposed by the api
 * for the body of each request.
 */
@Getter
@Setter
@Builder(toBuilder = true)
public class CurrencyRequest {

  @NotNull(message = "code cannot be null")
  @NotEmpty(message = "code cannot be empty")
  @JsonProperty("code")
  private String code;

  @NotNull(message = "description cannot be null")
  @NotEmpty(message = "description cannot be empty")
  @JsonProperty("description")
  private String description;

}
