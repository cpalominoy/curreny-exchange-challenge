package com.dev.currencyexchange.service;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import java.util.List;

public interface CurrencyService {

  List<CurrencyResponse> getAllCurrencies();
}
