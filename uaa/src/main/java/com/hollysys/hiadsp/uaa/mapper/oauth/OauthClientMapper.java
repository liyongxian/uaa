package com.hollysys.hiadsp.uaa.mapper.oauth;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;
@Mapper
public interface OauthClientMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(OauthClient record);

    int insertSelective(OauthClient record);

    OauthClient selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(OauthClient record);

    int updateByPrimaryKey(OauthClient record);
    
    int checkOauthClient(String clientId);
    
    List<OauthClient> selectAll();
}