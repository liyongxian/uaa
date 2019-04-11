package com.hollysys.hiadsp.uaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.permission.PermissionUtils;
import com.hollysys.hiadsp.common.model.role.RolePermission;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.mapper.permission.PermissionMapper;
import com.hollysys.hiadsp.uaa.mapper.role.RolePermissionMapper;
import com.hollysys.hiadsp.uaa.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    private static Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    
    @Override
    public List<MenuInfo> getWebMenus(String roleCode) {
	List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
	List<Permission> permissionList = permissionMapper.getPermissionsByRoleCode(Permission.APP_TYPE_WEB, Permission.RES_TYPE_MENU,
		roleCode);
	if (permissionList != null && permissionList.size() > 0) {
	    menuInfoList = PermissionUtils.permList2MenuList(permissionList);
	} else {
	    logger.warn("execute getWebMenus warn,permissionList is empty,roleCode=" + roleCode);
	}
	return menuInfoList;
    }

    /**
     * 获取WEB菜单
     */
    @Override
    public List<MenuInfo> getWebMenus(List<String> roleCodeList) {
	List<MenuInfo> menuInfoList = new ArrayList<MenuInfo>();
	List<Permission> permissionList = permissionMapper.getPermissionsByRoleCodeList(Permission.APP_TYPE_WEB, Permission.RES_TYPE_MENU,
		roleCodeList);
	if (permissionList != null && permissionList.size() > 0) {
	    menuInfoList = PermissionUtils.permList2MenuList(permissionList);
	} else {
	    logger.warn("execute getWebMenus warn,permissionList is empty,roleCodeList=" + roleCodeList.toString());
	}
	return menuInfoList;
    }

    @Override
    public List<ElementInfo> getWebElements(List<String> roleCodeList) {
	List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
	List<Permission> permissionList = permissionMapper.getPermissionsByRoleCodeList(Permission.APP_TYPE_WEB, Permission.RES_TYPE_ELEMENT,
		roleCodeList);
	if (permissionList != null && permissionList.size() > 0) {
	    elementInfoList = PermissionUtils.permList2ElementList(permissionList);
	} else {
	    logger.warn("execute getWebElements warn,permissionList is empty,roleCodeList=" + roleCodeList.toString());
	}
	return elementInfoList;
    }

    @Override
    public List<ElementInfo> getWebElements(String roleCode) {
	List<ElementInfo> elementInfoList = new ArrayList<ElementInfo>();
	List<Permission> permissionList = permissionMapper.getPermissionsByRoleCode(Permission.APP_TYPE_WEB, Permission.RES_TYPE_ELEMENT,
		roleCode);
	if (permissionList != null && permissionList.size() > 0) {
	    elementInfoList = PermissionUtils.permList2ElementList(permissionList);
	} else {
	    logger.warn("execute getWebElements warn,permissionList is empty,roleCode=" + roleCode);
	}
	return elementInfoList;
    }


    @Override
    public int addRolePermission(RolePermission rolePermission) {
	int result = -1;
	if(rolePermission == null){
	    logger.error("execute addRolePermission error,rolePermission can not be null");
	    return result;
	}
	if(StringUtils.isBlank(rolePermission.getCode())){
	    rolePermission.setCode(CodeUtil.getLongCode());
	}
	result = rolePermissionMapper.insert(rolePermission);
	return result;
    }

    @Override
    public int delRolePermissionByRole(String roleCode) {
	int result = -1;
	if(StringUtils.isBlank(roleCode)){
	    logger.error("execute delRolePermissionByRole error,roleCode can not be null");
	    return result;
	}
	result = rolePermissionMapper.deleteByRoleCode(roleCode);
	return result;
    }

    @Override
    public int addRolePermissions(List<RolePermission> rolePermissionList) {
	int result = -1;
	if(rolePermissionList == null || rolePermissionList.size() == 0){
	    logger.error("execute addRolePermissions error,rolePermissionList can not be null");
	    return result;
	}
	this.delRolePermissionByRole(rolePermissionList.get(0).getRoleCode());
	result = rolePermissionMapper.insertBatch(rolePermissionList);
	return 0;
    }
    @Override
    public List<RolePermission> getRolePermissionListByRole(String roleCode) {
	List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
	if(StringUtils.isBlank(roleCode)){
	    logger.error("execute getRolePermissionListByRole error,roleCode can not be null");
	    return rolePermissionList;
	}
	rolePermissionList = rolePermissionMapper.selectByRole(roleCode);
	return rolePermissionList;
    }
    @Override
    public List<RolePermission> getRolePermissionListByRole(String roleCode,String permissionType) {
	List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
	if(StringUtils.isBlank(roleCode) || StringUtils.isBlank(permissionType)){
	    logger.error("execute getRolePermissionListByRole error,roleCode and permissionType can not be null");
	    return rolePermissionList;
	}
	rolePermissionList = rolePermissionMapper.selectByRoleAndType(roleCode, permissionType);
	return rolePermissionList;
    }

    @Override
    public List<RolePermission> getRolePermissionListByPerm(String permCode) {
	List<RolePermission> rolePermissionList = new ArrayList<RolePermission>();
	if(StringUtils.isBlank(permCode)){
	    logger.error("execute getRolePermissionListByPerm error,permCode can not be null");
	    return rolePermissionList;
	}
	rolePermissionList = rolePermissionMapper.selectByPerm(permCode);
	return rolePermissionList;
    }

    @Override
    public List<Permission> getPermissionsByRole(String roleCode, String appType, String resType) {
	List<Permission> permissionList = new ArrayList<Permission>();
	if(StringUtils.isBlank(roleCode) || StringUtils.isBlank(appType) || StringUtils.isBlank(resType)){
	    logger.error("execute getPermissionsByRole error,param can not be null");
	    return permissionList;
	}
	return permissionMapper.getPermissionsByRoleCode(appType, resType, roleCode);
    }

    @Override
    public List<Permission> getPermissionsByRole(List<String> roleCodeList, String appType, String resType) {
	List<Permission> permissionList = new ArrayList<Permission>();
	if(roleCodeList.isEmpty() || StringUtils.isBlank(appType) || StringUtils.isBlank(resType)){
	    logger.error("execute getPermissionsByRole error,param can not be null");
	    return permissionList;
	}
	return permissionMapper.getPermissionsByRoleCodeList(appType, resType, roleCodeList);
    }

    @Override
    public List<Permission> getPermissionsByRole(String roleCode, String appType, String resType, String subType) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Permission> getPermissionsByRole(List<String> roleCodeList, String appType, String resType, String subType) {
	// TODO Auto-generated method stub
	return null;
    }

	@Override
	public List<String> seletRoleByPermUrl(String url) {
		// TODO Auto-generated method stub
		return this.rolePermissionMapper.seletRoleByPermUrl(url);
	}
}
