package com.dev.currencyexchange.controller;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.service.ExchangeRateService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Class that exposes the service via Http/Rest for client resource operations.
 */
@RestController
@RequestMapping("/service/v1/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<List<ExchangeRateResponse>> getAllExchangeRate() {
    return new ResponseEntity<>(exchangeRateService.getAllExchangeRate(), HttpStatus.OK);
  }


  @GetMapping(value = "/converter", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<CurrencyExchangeRateResponse> getCurrencyExchangeRate(
      @Valid CurrencyExchangeRateRequest request) {
    return new ResponseEntity<>(exchangeRateService.getCurrencyExchangeRate(request),
        HttpStatus.OK);
  }

  /**
   * Method registry ExchangeRate Controller.
   *
   * @param request ExchangeRateRequest
   * @return ExchangeRateResponse
   */
  @PostMapping(value = "/registry", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<ExchangeRateResponse> registryExchangeRate(
      @Valid @RequestBody ExchangeRateRequest request) {

    return new ResponseEntity<>(exchangeRateService.createExchangeRate(request),
        HttpStatus.CREATED);
  }

  /**
   * Method update Exchange Rate Controller.
   *
   * @param id      ExchangeRateId
   * @param request ExchangeRateRequest
   * @return ExchangeRateResponse
   */
  @PutMapping(value = "/{id}")
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<ExchangeRateResponse> updateExchangeRate(@PathVariable("id") Long id,
      @Valid @RequestBody ExchangeRateRequest request) {

    return new ResponseEntity<>(exchangeRateService.updateExchangeRate(id, request),
        HttpStatus.CREATED);
  }

}
