package com.hollysys.hiadsp.uaa.mapper.oauth;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;
@Mapper
public interface OauthResourceMapper {
    int deleteByPrimaryKey(String code);

    int insert(OauthResource record);

    int insertSelective(OauthResource record);

    OauthResource selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(OauthResource record);

    int updateByPrimaryKey(OauthResource record);
    
    List<OauthResource> getAll();
}