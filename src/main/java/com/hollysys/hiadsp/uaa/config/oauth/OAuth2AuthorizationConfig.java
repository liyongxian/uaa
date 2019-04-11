package com.hollysys.hiadsp.uaa.config.oauth;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.util.Assert;

import com.hollysys.hiadsp.uaa.oauth.token.CustomJwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
@PropertySource("classpath:application.properties")
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Environment env;

//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//	KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray()).getKeyPair("test");
//	converter.setKeyPair(keyPair);
//	return converter;
//    }

    @Bean
    public CustomJwtAccessTokenConverter jwtAccessTokenConverter() {
	// KeyPair keyPair = new KeyStoreKeyFactory(new
	// ClassPathResource("uaaserver.keystore"),
	// "hollysys".toCharArray()).getKeyPair("uaaserver");
	KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource("keystore.jks"), "foobar".toCharArray()).getKeyPair("test");
	PrivateKey privateKey = keyPair.getPrivate();
	Assert.state(privateKey instanceof RSAPrivateKey, "KeyPair must be an RSA ");
	Signer signer = new RsaSigner((RSAPrivateKey) privateKey);
	CustomJwtAccessTokenConverter converter = new CustomJwtAccessTokenConverter();
	converter.setKeyPair(keyPair);
	converter.setSigner(signer);
	converter.setZid(env.getProperty("uaa.zid", "uaa"));
	converter.setIss(env.getProperty("uaa.iss", "http://192.168.66.158:18080/uaa/oauth/token"));
	return converter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	clients.withClientDetails(clientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(myUserDetailService());
	 endpoints.tokenStore(tokenStore());
    }

     @Bean
     @Primary
     public DefaultTokenServices tokenServices() {
     // 配置TokenServices参数
     DefaultTokenServices tokenServices = new DefaultTokenServices();
     tokenServices.setSupportRefreshToken(true);
     tokenServices.setAccessTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1)); // 1天
     tokenServices.setRefreshTokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(7));// 7天
     tokenServices.setTokenStore(tokenStore());
     tokenServices.setTokenEnhancer(jwtAccessTokenConverter());
     return tokenServices;
     }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
	// oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
	oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()").allowFormAuthenticationForClients();
    }

    @Bean
    public ClientDetailsService clientDetailsService() {
	return new MultitenantJdbcClientDetailsService(jdbcTemplate);
    }

    @Bean
    public TokenStore tokenStore() {
	return new JdbcTokenStore(dataSource);
    }

    // 从数据库中读取用户数据
    @Bean
    public DbUserDetailService myUserDetailService() {
	return new DbUserDetailService();
    }

    // 认证方法
    @Bean
    public DbPasswordEncoder passwordEncoder() {
	// BCryptPaswordEncoder是PasswordEncoder的一种实现，可以根据自己的需要实现该Encoder
	return new DbPasswordEncoder();
    }

}
