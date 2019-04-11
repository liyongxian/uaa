package com.hollysys.hiadsp.uaa.service.oauth;

import java.util.List;

import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;

public interface OauthClientService {
    
    public OauthClient getOauthClientById(String clientId);

    public List<OauthClient> getOauthClientList();

    public int addOauthClient(OauthClient oauthClient);

    public int updateOauthClient(OauthClient oauthClient);

    public int deleteById(String clientId);
    
    public boolean checkOauthClient(String clientId );
}
