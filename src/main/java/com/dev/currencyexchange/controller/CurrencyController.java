package com.dev.currencyexchange.controller;

import com.dev.currencyexchange.dto.currency.CurrencyRequest;
import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.service.CurrencyService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Class that exposes the service via Http/Rest for client resource operations.
 */
@RestController
@RequestMapping("/service/v1/currency")
@RequiredArgsConstructor
public class CurrencyController {

  private final CurrencyService currencyService;

  @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<List<CurrencyResponse>> getAllCurrencies() {
    return new ResponseEntity<>(currencyService.getAllCurrencies(), HttpStatus.OK);
  }

  @PostMapping(value = "/registry",
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAnyAuthority('ADMIN_USER') or hasAnyAuthority('STANDARD_USER')")
  public ResponseEntity<CurrencyResponse> registryCurrency(@RequestBody CurrencyRequest request) {
    return new ResponseEntity<>(currencyService.registryCurrency(request), HttpStatus.CREATED);
  }


}
