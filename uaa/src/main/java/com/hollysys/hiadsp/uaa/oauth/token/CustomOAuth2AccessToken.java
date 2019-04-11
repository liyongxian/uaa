package com.hollysys.hiadsp.uaa.oauth.token;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class CustomOAuth2AccessToken extends DefaultOAuth2AccessToken {

    private static final long serialVersionUID = 1L;
    private String iss;
    private String zid="uaa";
    private int  iat = 0;
    
    public CustomOAuth2AccessToken(OAuth2AccessToken accessToken) {
	super(accessToken);
	if(accessToken instanceof CustomOAuth2AccessToken){
	    this.iss = ((CustomOAuth2AccessToken)accessToken).getIss();
	    this.zid = ((CustomOAuth2AccessToken)accessToken).getZid();
	    this.iat  = ((CustomOAuth2AccessToken)accessToken).getIat();
	}
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
    public int getIat() {
        return iat;
    }
    public void setIat(int iat) {
        this.iat = iat;
    }
    
}
