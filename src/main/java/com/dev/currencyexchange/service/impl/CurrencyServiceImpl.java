package com.dev.currencyexchange.service.impl;

import com.dev.currencyexchange.dto.currency.CurrencyRequest;
import com.dev.currencyexchange.dto.currency.CurrencyResponse;
import com.dev.currencyexchange.dto.mapper.CurrencyMapper;
import com.dev.currencyexchange.respository.CurrencyRepository;
import com.dev.currencyexchange.service.CurrencyService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implements Service Interface Class for Currency business logic.
 */
@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  private final CurrencyRepository currencyRepository;
  private final CurrencyMapper currencyMapper;

  /**
   * Method list of Currencies.
   *
   * @return List of CurrencyResponse
   */
  @Override
  public List<CurrencyResponse> getAllCurrencies() {
    return currencyRepository.findAll()
        .stream()
        .map(currencyMapper::toResponseDto)
        .collect(Collectors.toList());
  }

  /**
   * Method Currency Registry Service.
   *
   * @param request CurrencyRequest
   * @return CurrencyResponse
   */
  @Override
  public CurrencyResponse registryCurrency(CurrencyRequest request) {

    return currencyMapper.toResponseDto(currencyRepository.save(currencyMapper.toEntity(request)));
  }
}
