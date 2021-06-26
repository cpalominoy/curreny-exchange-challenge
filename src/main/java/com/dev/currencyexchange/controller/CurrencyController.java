package com.dev.currencyexchange.controller;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.service.CurrencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/v1/currency")
@RequiredArgsConstructor
public class CurrencyController {

  private final CurrencyService currencyService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CurrencyResponse>> getAllCurrencies() {
    return new ResponseEntity<>(currencyService.getAllCurrencies(), HttpStatus.OK);
  }

}
