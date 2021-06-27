package com.dev.currencyexchange.service;

import com.dev.currencyexchange.dto.currency.CurrencyRequest;
import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import java.util.List;

/**
 * Service Interface Class for Currency business logic.
 */
public interface CurrencyService {

  List<CurrencyResponse> getAllCurrencies();


  CurrencyResponse registryCurrency(CurrencyRequest request);
}
