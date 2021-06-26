package com.dev.currencyexchange.service.impl;

import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.dto.mapper.CurrencyMapper;
import com.dev.currencyexchange.respository.CurrencyRepository;
import com.dev.currencyexchange.service.CurrencyService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyRepository currencyRepository;
  private final CurrencyMapper currencyMapper;

  @Override
  public List<CurrencyResponse> getAllCurrencies() {
    return currencyRepository.findAll()
        .stream()
        .map(currencyMapper::toResponseDto)
        .collect(Collectors.toList());
  }
}
