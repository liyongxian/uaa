package com.hollysys.hiadsp.uaa.config.oauth;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@Order(-20)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    // // http.authorizeRequests().antMatchers("/token_key").permitAll()
    // // .and().formLogin().loginPage("/login").permitAll()
    // // .and().requestMatchers().antMatchers("/login", "/oauth/authorize")
    // // .and().authorizeRequests().anyRequest().authenticated()
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	 http.antMatcher("/token_key").antMatcher("/css/**").antMatcher("/js/**").authorizeRequests().anyRequest().permitAll()
	 .and().formLogin().loginPage("/login").permitAll()
	 .and().csrf().disable();//csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//	 .and().csrf().disable();
	// @formatter:off
	http.requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
		.and().authorizeRequests().anyRequest().authenticated();
	// @formatter:on
    }

}