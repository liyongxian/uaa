package com.hollysys.hiadsp.uaa.response.oauth;

import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class OauthResourceResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private OauthResource oauthResource;
    public OauthResource getOauthResource() {
        return oauthResource;
    }
    public void setOauthResource(OauthResource oauthResource) {
        this.oauthResource = oauthResource;
    }

    
}
