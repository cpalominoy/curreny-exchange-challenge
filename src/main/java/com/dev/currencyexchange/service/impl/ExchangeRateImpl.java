package com.dev.currencyexchange.service.impl;

import com.dev.currencyexchange.dto.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.mapper.CurrencyExchangeRateMapper;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import com.dev.currencyexchange.respository.ExchangeRateRepository;
import com.dev.currencyexchange.service.ExchangeRateService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;

  private final CurrencyExchangeRateMapper currencyExchangeRateMapper;

  @Override
  public CurrencyExchangeRateResponse getExchangeRate(CurrencyExchangeRateRequest request) {

    Optional<ExchangeRateEntity> entity = exchangeRateRepository
        .findExchangeRateEntityBySourceCurrencyAndTargetCurrency(
            request.getSourceCurrency(), request.getTargetCurrency());
    
    if (entity.isPresent()) {
      return currencyExchangeRateMapper
          .toGenerateDto(entity.get(), request.getAmount());
    } else {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT, String
          .format("No data found for source: %s , target: %s ", request.getSourceCurrency(),
              request.getTargetCurrency()));
    }
  }
}
