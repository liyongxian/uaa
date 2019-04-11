package com.hollysys.hiadsp.uaa.mapper.permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hollysys.hiadsp.common.model.permission.Permission;

@Mapper
public interface PermissionMapper {
    int deleteByPrimaryKey(String code);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    int updateLeafState(@Param("code")String code,@Param("isLeaf")String isLeaf);
    
    List<Permission> getAllPermission();
    List<Permission> getPermissionList(@Param("appType")String appType,@Param("resType")String resType,@Param("resSubType")String resSubType);
    List<Permission> getChildren(String parentCode);
    List<Permission> getPermissionsByRoleCode(@Param("appType")String appType,@Param("resType")String resType,@Param("roleCode")String roleCode);
    List<Permission> getPermissionsByRoleCodeList(@Param("appType")String appType,@Param("resType")String resType,@Param("roleCodeList")List<String> roleCodeList);
    
}