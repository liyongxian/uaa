package com.hollysys.hiadsp.uaa.oauth.token;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.jwt.crypto.sign.Signer;
import org.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.DefaultOAuth2RefreshToken;
import org.springframework.security.oauth2.common.ExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {
    private JsonParser objectMapper = JsonParserFactory.create();
    private boolean includeGrantType;
    private String verifierKey = new RandomValueStringGenerator().generate();
    private Signer signer = new MacSigner(verifierKey);
    private String iss;
    private String zid;
    
    public Signer getSigner() {
        return signer;
    }

    public void setSigner(Signer signer) {
        this.signer = signer;
    }


    public boolean isIncludeGrantType() {
	return includeGrantType;
    }

    public void setIncludeGrantType(boolean includeGrantType) {
	this.includeGrantType = includeGrantType;
    }
    

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    @Override
    public CustomOAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	CustomOAuth2AccessToken result = new CustomOAuth2AccessToken(accessToken);
	Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
	String tokenId = result.getValue();
	if (!info.containsKey(TOKEN_ID)) {
	    info.put(TOKEN_ID, tokenId);
	} else {
	    tokenId = (String) info.get(TOKEN_ID);
	}
	result.setAdditionalInformation(info);
	result.setIss(iss);
	result.setZid(zid);
	result.setValue(encode(result, authentication));
	OAuth2RefreshToken refreshToken = result.getRefreshToken();
	if (refreshToken != null) {
	    CustomOAuth2AccessToken encodedRefreshToken = new CustomOAuth2AccessToken(accessToken);
	    encodedRefreshToken.setValue(refreshToken.getValue());
	    // Refresh tokens do not expire unless explicitly of the right type
	    encodedRefreshToken.setExpiration(null);
	    encodedRefreshToken.setIss(iss);
	    encodedRefreshToken.setZid(zid);
	    encodedRefreshToken.setIat(0);
	    try {
		Map<String, Object> claims = objectMapper.parseMap(JwtHelper.decode(refreshToken.getValue()).getClaims());
		if (claims.containsKey(TOKEN_ID)) {
		    encodedRefreshToken.setValue(claims.get(TOKEN_ID).toString());
		}
	    } catch (IllegalArgumentException e) {
	    }
	    Map<String, Object> refreshTokenInfo = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
	    refreshTokenInfo.put(TOKEN_ID, encodedRefreshToken.getValue());
	    refreshTokenInfo.put(ACCESS_TOKEN_ID, tokenId);
	    encodedRefreshToken.setAdditionalInformation(refreshTokenInfo);
	    DefaultOAuth2RefreshToken token = new DefaultOAuth2RefreshToken(encode(encodedRefreshToken, authentication));
	    if (refreshToken instanceof ExpiringOAuth2RefreshToken) {
		Date expiration = ((ExpiringOAuth2RefreshToken) refreshToken).getExpiration();
		encodedRefreshToken.setExpiration(expiration);
		token = new DefaultExpiringOAuth2RefreshToken(encode(encodedRefreshToken, authentication), expiration);
	    }
	    result.setRefreshToken(token);
	}
	return result;
    }

    public String encode(CustomOAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	String content;
	try {
	    content = objectMapper.formatMap(convertAccessToken(accessToken, authentication));
	} catch (Exception e) {
	    throw new IllegalStateException("Cannot convert access token to JSON", e);
	}
	String token = JwtHelper.encode(content, signer).getEncoded();
	return token;
    }

    public Map<String, ?> convertAccessToken(CustomOAuth2AccessToken token, OAuth2Authentication authentication) {
	Map<String, Object> response = new HashMap<String, Object>();
	OAuth2Request clientToken = authentication.getOAuth2Request();

	if (!authentication.isClientOnly()) {
	    UserAuthenticationConverter userTokenConverter = new DefaultUserAuthenticationConverter();
	    response.putAll(userTokenConverter.convertUserAuthentication(authentication.getUserAuthentication()));
	} else {
	    if (clientToken.getAuthorities() != null && !clientToken.getAuthorities().isEmpty()) {
		response.put(UserAuthenticationConverter.AUTHORITIES, AuthorityUtils.authorityListToSet(clientToken.getAuthorities()));
	    }
	}

	if (token.getScope() != null) {
	    response.put(SCOPE, token.getScope());
	}
	if (token.getAdditionalInformation().containsKey(JTI)) {
	    response.put(JTI, token.getAdditionalInformation().get(JTI));
	}

	if (token.getExpiration() != null) {
	    response.put(EXP, token.getExpiration().getTime() / 1000);
	}

	if (includeGrantType && authentication.getOAuth2Request().getGrantType() != null) {
	    response.put(GRANT_TYPE, authentication.getOAuth2Request().getGrantType());
	}
	// add begin
	if (StringUtils.isNotEmpty(token.getIss())) {
	    response.put("iss", token.getIss());
	}
	if (StringUtils.isNotEmpty(token.getZid())) {
	    response.put("zid", token.getZid());
	}
	response.put("iat", token.getIat());
	// add end
	response.putAll(token.getAdditionalInformation());

	response.put(CLIENT_ID, clientToken.getClientId());
	if (clientToken.getResourceIds() != null && !clientToken.getResourceIds().isEmpty()) {
	    response.put(AUD, clientToken.getResourceIds());
	}
	return response;
    }
}
