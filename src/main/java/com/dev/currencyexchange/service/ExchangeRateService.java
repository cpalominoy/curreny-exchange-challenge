package com.dev.currencyexchange.service;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import java.util.List;

/**
 * Service Interface Class for ExchangeRate business logic.
 */

public interface ExchangeRateService {

  List<ExchangeRateResponse> getAllExchangeRate();

  CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request);

  ExchangeRateResponse createExchangeRate(ExchangeRateRequest request);

  ExchangeRateResponse updateExchangeRate(Long id, ExchangeRateRequest request);
}
