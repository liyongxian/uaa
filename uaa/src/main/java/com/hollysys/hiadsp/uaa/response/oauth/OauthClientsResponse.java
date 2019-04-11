package com.hollysys.hiadsp.uaa.response.oauth;

import java.util.List;

import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class OauthClientsResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<OauthClient> oauthClients;
    public List<OauthClient> getOauthClients() {
        return oauthClients;
    }
    public void setOauthClients(List<OauthClient> oauthClients) {
        this.oauthClients = oauthClients;
    }

    
}
