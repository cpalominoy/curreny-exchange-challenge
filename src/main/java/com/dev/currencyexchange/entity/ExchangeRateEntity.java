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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
