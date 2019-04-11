package com.hollysys.hiadsp.uaa.response.oauth;

import java.util.List;

import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class OauthResourcesResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<OauthResource> oauthResources;

    public List<OauthResource> getOauthResources() {
	return oauthResources;
    }

    public void setOauthResources(List<OauthResource> oauthResources) {
	this.oauthResources = oauthResources;
    }

}
