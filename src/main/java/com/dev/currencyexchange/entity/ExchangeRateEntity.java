package com.dev.currencyexchange.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class Data Access Object for entity ExchangeRate.
 */
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_EXCHANGE_RATE")
public class ExchangeRateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EXCHANGE_RATE_ID", nullable = false)
  private Long id;


  @ManyToOne
  @JoinColumn(name = "SOURCE_CURRENCY_ID")
  private CurrencyEntity sourceCurrencyEntity;

  @ManyToOne
  @JoinColumn(name = "TARGET_CURRENCY_ID")
  private CurrencyEntity targetCurrencyEntity;

  @Column(name = "RATE")
  private BigDecimal rate;

}
