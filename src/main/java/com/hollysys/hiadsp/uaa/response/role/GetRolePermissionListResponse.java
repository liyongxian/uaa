/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.response.role;

import java.util.List;

import com.hollysys.hiadsp.common.model.role.RolePermission;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

/**
 * <p>
 * 功能描述,该部分必须以中文句号结尾。
 * <p>
 * 
 * @author kangkai
 * @since 1.0.0
 */
public class GetRolePermissionListResponse extends BaseResponse {
	//
	private static final long serialVersionUID = 1L;
	private List<RolePermission> rolePermissionList;
	public List<RolePermission> getRolePermissionList() {
	    return rolePermissionList;
	}
	public void setRolePermissionList(List<RolePermission> rolePermissionList) {
	    this.rolePermissionList = rolePermissionList;
	}
	
}
