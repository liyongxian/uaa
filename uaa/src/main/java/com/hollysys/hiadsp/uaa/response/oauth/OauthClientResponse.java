package com.hollysys.hiadsp.uaa.response.oauth;

import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class OauthClientResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private OauthClient oauthClient;

    public OauthClient getOauthClient() {
	return oauthClient;
    }

    public void setOauthClient(OauthClient oauthClient) {
	this.oauthClient = oauthClient;
    }

}
