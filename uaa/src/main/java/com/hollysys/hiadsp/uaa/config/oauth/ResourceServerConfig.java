package com.hollysys.hiadsp.uaa.config.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
	// @formatter:off
	http.authorizeRequests().antMatchers("/token_key","/authentication","/css/**","/js/**","/role/permission/seletRoleByPermUrl","/user/addUser","/user/delUser").permitAll()
	.antMatchers("/role/**").authenticated()
	.antMatchers("/permission/**").authenticated()
	.antMatchers("/user/**").authenticated();
	// @formatter:on
    }

}