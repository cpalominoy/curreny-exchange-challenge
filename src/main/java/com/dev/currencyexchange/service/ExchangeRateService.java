package com.dev.currencyexchange.service;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import java.util.List;

public interface ExchangeRateService {

  List<ExchangeRateResponse> getAllExchangeRate();

  CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request);
}
