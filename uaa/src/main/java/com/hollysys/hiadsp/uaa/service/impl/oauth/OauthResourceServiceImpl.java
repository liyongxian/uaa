package com.hollysys.hiadsp.uaa.service.impl.oauth;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.mapper.oauth.OauthResourceMapper;
import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;
import com.hollysys.hiadsp.uaa.service.oauth.OauthResourceService;

@Service("oauthResourceService")
public class OauthResourceServiceImpl implements OauthResourceService {
    private static Logger logger = LoggerFactory.getLogger(OauthResourceServiceImpl.class);
    @Autowired
    private OauthResourceMapper oauthResourceMapper;

    @Override
    public List<OauthResource> getAll() {
	return this.oauthResourceMapper.getAll();
    }

    @Override
    public OauthResource getByCode(String code) {
	if (StringUtils.isEmpty(code)) {
	    logger.error("execute getByCode error,code can not be null");
	    return null;
	}
	return this.oauthResourceMapper.selectByPrimaryKey(code);
    }

    @Override
    public int add(OauthResource oauthResource) {
	if (oauthResource == null) {
	    logger.error("execute add error,oauthResource can not be null");
	    return -1;
	}
	if (StringUtils.isEmpty(oauthResource.getCode())) {
	    oauthResource.setCode(CodeUtil.getLongCode());
	}
	int result = this.oauthResourceMapper.insert(oauthResource);
	return result;
    }

    @Override
    public int update(OauthResource oauthResource) {
	if (oauthResource == null) {
	    logger.error("execute add error,oauthResource can not be null");
	    return -1;
	}
	if (StringUtils.isEmpty(oauthResource.getCode())) {
	    logger.error("execute update error,oauthResource.code can not be null");
	    return -1;
	}
	int result = this.oauthResourceMapper.updateByPrimaryKey(oauthResource);
	return result;
    }

    @Override
    public int deleteByCode(String code) {
	if (StringUtils.isEmpty(code)) {
	    logger.error("execute deleteByCode error,code can not be null");
	    return -1;
	}
	int result = this.oauthResourceMapper.deleteByPrimaryKey(code);
	return result;
    }

}
