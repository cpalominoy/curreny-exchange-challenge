package com.dev.currencyexchange.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  @Column(name = "ID_EXCHANGE_RATE", nullable = false)
  private Long id;

  @Column(name = "SOURCE_CURRENCY", nullable = false)
  private String sourceCurrency;

  @Column(name = "TARGET_CURRENCY")
  private String targetCurrency;

  @Column(name = "RATE")
  private BigDecimal rate;

}
