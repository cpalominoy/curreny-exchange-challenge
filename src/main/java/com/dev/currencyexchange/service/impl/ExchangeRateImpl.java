package com.dev.currencyexchange.service.impl;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.dto.mapper.CurrencyExchangeRateMapper;
import com.dev.currencyexchange.dto.mapper.ExchangeRateMapper;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import com.dev.currencyexchange.respository.ExchangeRateRepository;
import com.dev.currencyexchange.service.ExchangeRateService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;
  private final ExchangeRateMapper exchangeRateMapper;
  private final CurrencyExchangeRateMapper currencyExchangeRateMapper;

  @Override
  public List<ExchangeRateResponse> getAllExchangeRate() {
    return exchangeRateRepository
        .findAll()
        .stream()
        .map(exchangeRateMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  @Override
  public CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request) {

    Optional<ExchangeRateEntity> entity = exchangeRateRepository.findRateByCurrency(
        request.getSource(), request.getTarget());

    if (entity.isPresent()) {
      return currencyExchangeRateMapper.toGenerateDto(entity.get(), request.getAmount());
    } else {
      throw new ResponseStatusException(HttpStatus.NO_CONTENT, String
          .format("No data found for source: %s , target: %s ", request.getSource(),
              request.getTarget()));
    }
  }
}
