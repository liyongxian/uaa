package com.hollysys.hiadsp.uaa.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hollysys.hiadsp.common.model.user.UserOrg;
@Mapper
public interface UserOrgMapper {
    int deleteByPrimaryKey(String code);
    
    int deleteByUserCode(String userCode);
    
    int deleteByOrgCode(String orgCode);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    UserOrg selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
    UserOrg selectByUserCode(String userCode);
    List<UserOrg> selectByOrgCode(String orgCode);
    List<UserOrg> selectByOrgCodeList(List<String> orgCodeList);
}