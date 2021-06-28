package com.dev.currencyexchange.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  private final ResourceServerTokenServices tokenServices;

  @Value("${security.jwt.resource-ids}")
  private String resourceIds;


  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId(resourceIds).tokenServices(tokenServices);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .requestMatchers()
        .and()
        .authorizeRequests()
        .antMatchers("/service/v1/exchange-rate/**", "/service/v1/currency/**").authenticated();

    //habilitar el h2-console
    http.csrf().disable();
    http.headers().frameOptions().disable();

  }
}