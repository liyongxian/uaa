package com.hollysys.hiadsp.uaa.service.oauth;

import java.util.List;

import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;

public interface OauthResourceService {
    
    public List<OauthResource> getAll();
    
    public OauthResource getByCode(String code);
    
    public int add(OauthResource oauthResource);
    
    public int update(OauthResource oauthResource);
    
    public int deleteByCode(String code);
}
