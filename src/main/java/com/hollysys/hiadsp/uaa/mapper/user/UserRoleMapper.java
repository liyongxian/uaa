package com.hollysys.hiadsp.uaa.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hollysys.hiadsp.common.model.user.UserRole;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(String code);
    
    int deleteByUserCode(String userCode);

    int insert(UserRole record);
    
    int insertBatch(List<UserRole> record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String code);
    
    List<UserRole> selectByUserCode(String userCode);
    
    List<UserRole> selectByRoleCode(String roleCode);
    
    List<UserRole> selectByRoleCodeList(List<String> roleCodeList);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}