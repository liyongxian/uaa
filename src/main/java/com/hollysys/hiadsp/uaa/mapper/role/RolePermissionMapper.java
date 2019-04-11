package com.hollysys.hiadsp.uaa.mapper.role;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hollysys.hiadsp.common.model.role.RolePermission;

@Mapper
public interface RolePermissionMapper {
    int deleteByPrimaryKey(String code);
    
    int deleteByRoleCode(String roleCode);

    int insert(RolePermission record);
    
    int insertBatch(List<RolePermission> item);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(String code);
    
    List<RolePermission> selectByRole(String roleCode);
    
    List<RolePermission> selectByPerm(String permCode);
    List<String>seletRoleByPermUrl(@Param("url")String url);
    
    List<RolePermission> selectByRoleAndType(@Param("roleCode")String roleCode,@Param("permType")String permType);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}