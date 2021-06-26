package com.dev.currencyexchange.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_CURRENCY")
public class CurrencyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CURRENCY_ID")
  private Long id;

  @Column(name = "CODE")
  private String code;

  @Column(name = "DESCRIPTION")
  private String description;

  @OneToMany(mappedBy = "sourceCurrencyEntity", fetch = FetchType.EAGER)
  private Set<ExchangeRateEntity> source;

  @OneToMany(mappedBy = "targetCurrencyEntity", fetch = FetchType.EAGER)
  private Set<ExchangeRateEntity> target;


}
