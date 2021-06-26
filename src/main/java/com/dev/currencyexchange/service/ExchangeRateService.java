package com.dev.currencyexchange.service;

import com.dev.currencyexchange.dto.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.CurrencyExchangeRateResponse;

public interface ExchangeRateService {

  CurrencyExchangeRateResponse getExchangeRate(CurrencyExchangeRateRequest request);
}
