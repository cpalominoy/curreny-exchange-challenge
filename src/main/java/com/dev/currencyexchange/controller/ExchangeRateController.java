package com.dev.currencyexchange.controller;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.service.ExchangeRateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/v1/exchange-rate")
@RequiredArgsConstructor
public class ExchangeRateController {

  private final ExchangeRateService exchangeRateService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ExchangeRateResponse> getAllExchangeRate() {
    return exchangeRateService.getAllExchangeRate();
  }


  @GetMapping(value = "/converter", produces = MediaType.APPLICATION_JSON_VALUE)
  public CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request) {
    return exchangeRateService.getCurrencyExchangeRate(request);
  }

 
}
