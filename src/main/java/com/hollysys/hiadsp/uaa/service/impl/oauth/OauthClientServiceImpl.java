package com.hollysys.hiadsp.uaa.service.impl.oauth;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.uaa.mapper.oauth.OauthClientMapper;
import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;
import com.hollysys.hiadsp.uaa.service.oauth.OauthClientService;

@Service("oauthClientService")
public class OauthClientServiceImpl implements OauthClientService {
    private static Logger logger = LoggerFactory.getLogger(OauthClientServiceImpl.class);
    @Autowired
    private OauthClientMapper oauthClientMapper;

    @Override
    public OauthClient getOauthClientById(String clientId) {
	if(StringUtils.isEmpty(clientId)){
	    logger.error("execute getOauthClientById error,clientId can not be null");
	    return null;
	}
	OauthClient oauthClient = oauthClientMapper.selectByPrimaryKey(clientId);
	return oauthClient;
    }

    @Override
    public List<OauthClient> getOauthClientList() {
	return oauthClientMapper.selectAll();
    }

    @Override
    public int addOauthClient(OauthClient oauthClient) {
	if(oauthClient == null){
	    logger.error("execute addOauthClient error,oauthClient can not be null");
	    return -1;
	}
	if(StringUtils.isEmpty(oauthClient.getClientId())){
	    logger.error("execute addOauthClient error,oauthClient.id can not be null");
	    return -1;
	}
	if(StringUtils.isEmpty(oauthClient.getClientSecret())){
	    oauthClient.setClientSecret(UUID.randomUUID().toString());
	}
	if(StringUtils.isEmpty(oauthClient.getScope())){
	    oauthClient.setScope(OauthClient.DEFAULT_SCOPE);
	}
	if(StringUtils.isEmpty(oauthClient.getAutoapprove())){
	    oauthClient.setAutoapprove(OauthClient.DEFAULT_AUTOAPPROVE);
	}
	return this.oauthClientMapper.insertSelective(oauthClient);
    }

    @Override
    public int updateOauthClient(OauthClient oauthClient) {
	if(oauthClient == null){
	    logger.error("execute updateOauthClient error,oauthClient can not be null");
	    return -1;
	}
	if(StringUtils.isEmpty(oauthClient.getClientId())){
	    logger.error("execute addOauthClient error,oauthClient.id can not be null");
	    return -1;
	}
	if(StringUtils.isEmpty(oauthClient.getClientSecret())){
	    oauthClient.setClientSecret(UUID.randomUUID().toString());
	}
	if(StringUtils.isEmpty(oauthClient.getScope())){
	    oauthClient.setScope(OauthClient.DEFAULT_SCOPE);
	}
	if(StringUtils.isEmpty(oauthClient.getAutoapprove())){
	    oauthClient.setAutoapprove(OauthClient.DEFAULT_AUTOAPPROVE);
	}
	return this.oauthClientMapper.updateByPrimaryKeySelective(oauthClient);
    }

    @Override
    public int deleteById(String clientId) {
	if (StringUtils.isEmpty(clientId)) {
	    logger.error("execute deleteById error,clientId can not be null");
	    return -1;
	}
	return this.oauthClientMapper.deleteByPrimaryKey(clientId);
    }

    @Override
    public boolean checkOauthClient(String clientId) {
	if (StringUtils.isEmpty(clientId)) {
	    logger.error("execute checkOauthClientExist error,clientId can not be null");
	    return false;
	}
	return this.oauthClientMapper.checkOauthClient(clientId)>0?false:true;
    }

}
