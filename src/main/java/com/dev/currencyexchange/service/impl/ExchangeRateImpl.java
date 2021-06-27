package com.dev.currencyexchange.service.impl;

import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.CurrencyExchangeRateResponse;
import com.dev.currencyexchange.dto.exchange.ExchangeRateRequest;
import com.dev.currencyexchange.dto.exchange.ExchangeRateResponse;
import com.dev.currencyexchange.dto.mapper.CurrencyExchangeRateMapper;
import com.dev.currencyexchange.dto.mapper.ExchangeRateMapper;
import com.dev.currencyexchange.entity.CurrencyEntity;
import com.dev.currencyexchange.entity.ExchangeRateEntity;
import com.dev.currencyexchange.respository.CurrencyRepository;
import com.dev.currencyexchange.respository.ExchangeRateRepository;
import com.dev.currencyexchange.service.ExchangeRateService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


/**
 * Implements Service Interface Class for ExchangeRate business logic.
 */
@Service
@RequiredArgsConstructor
public class ExchangeRateImpl implements ExchangeRateService {

  private final ExchangeRateRepository exchangeRateRepository;
  private final CurrencyRepository currencyRepository;

  private final ExchangeRateMapper exchangeRateMapper;
  private final CurrencyExchangeRateMapper currencyExchangeRateMapper;

  /**
   * Method List all ExchangeRate.
   *
   * @return List of ExchangeRateResponse
   */
  @Override
  public List<ExchangeRateResponse> getAllExchangeRate() {

    List<ExchangeRateEntity> exchangeRateEntities = exchangeRateRepository.findAll();

    if (!exchangeRateEntities.isEmpty()) {
      return exchangeRateEntities
          .stream()
          .map(exchangeRateMapper::toResponseDto)
          .collect(Collectors.toList());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data found for exchangeRate");
    }
  }

  /**
   * method to obtain the exchange rate by currency (source-target).
   *
   * @param request CurrencyExchangeRateRequest
   * @return CurrencyExchangeRateResponse
   */
  @Override
  public CurrencyExchangeRateResponse getCurrencyExchangeRate(CurrencyExchangeRateRequest request) {

    Optional<ExchangeRateEntity> entity = exchangeRateRepository.findRateByCurrency(
        request.getSource(), request.getTarget());

    if (entity.isPresent()) {
      return currencyExchangeRateMapper.toGenerateDto(entity.get(), request.getAmount());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          String.format("No data found for source: %s , target: %s ", request.getSource(),
              request.getTarget()));
    }
  }

  /**
   * Method ExchangeRate registry Service.
   *
   * @param request ExchangeRateRequest
   * @return ExchangeRateResponse
   */
  @Override
  public ExchangeRateResponse createExchangeRate(ExchangeRateRequest request) {

    Optional<ExchangeRateEntity> exchangeRateValidate = exchangeRateRepository
        .findBySourceCurrencyEntity_IdAndTargetCurrencyEntity_Id(request.getSourceCurrency(),
            request.getTargetCurrency());

    if (exchangeRateValidate.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          String.format("This combination is already registered source: %d, target: %d",
              request.getSourceCurrency(),
              request.getTargetCurrency()));
    }

    Optional<CurrencyEntity> sourceEntity = currencyRepository
        .findById(request.getSourceCurrency());

    Optional<CurrencyEntity> targetEntity = currencyRepository
        .findById(request.getTargetCurrency());

    if (sourceEntity.isPresent() && targetEntity.isPresent()) {

      ExchangeRateEntity exchangeRateEntity = exchangeRateMapper
          .toEntity(request, sourceEntity.get(), targetEntity.get());
      return exchangeRateMapper.toResponseDto(exchangeRateRepository.save(exchangeRateEntity));

    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, String
          .format("No data found for source: %d , target: %d ", request.getSourceCurrency(),
              request.getTargetCurrency()));
    }


  }

  /**
   * Method to update exchange rate values.
   *
   * @param id      ExchangeRateId
   * @param request ExchangeRateRequest
   * @return ExchangeRateResponse
   */
  @Override
  public ExchangeRateResponse updateExchangeRate(Long id, ExchangeRateRequest request) {

    Optional<ExchangeRateEntity> exchangeRateNow = exchangeRateRepository.findById(id);

    if (exchangeRateNow.isPresent()) {

      Optional<CurrencyEntity> sourceEntity = currencyRepository
          .findById(request.getSourceCurrency());

      Optional<CurrencyEntity> targetEntity = currencyRepository
          .findById(request.getTargetCurrency());

      if (sourceEntity.isEmpty() || targetEntity.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String
            .format("No data found for source: %d , target: %d ", request.getSourceCurrency(),
                request.getTargetCurrency()));
      }

      ExchangeRateEntity exchangeRateEntity = exchangeRateMapper
          .toEntity(request, sourceEntity.get(), targetEntity.get(), exchangeRateNow.get().getId());
      return exchangeRateMapper.toResponseDto(exchangeRateRepository.save(exchangeRateEntity));

    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
          String.format("No data found for Id: %d", id));
    }

  }
}
