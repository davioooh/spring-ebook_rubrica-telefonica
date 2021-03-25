package com.davioooh.rubricatelefonica.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(WebSecurity web) {
    web.ignoring()
      .antMatchers("/css/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests(authorizeRequests ->
        authorizeRequests
          .mvcMatchers("/").permitAll()
          .anyRequest().authenticated()
      )
      .formLogin(login ->
        login.permitAll()
          .loginPage("/login")
          .defaultSuccessUrl("/contacts")
      )
      .logout().permitAll();
  }

}