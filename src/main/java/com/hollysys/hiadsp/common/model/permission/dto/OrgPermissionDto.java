/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.common.model.permission.dto;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 功能描述,该部分必须以中文句号结尾。
 * <p>
 *
 * 创建日期 2016年11月29日<br>
 * @author  zhuqinghua@emcc.net.cn<p>
 * @since  1.0.0
 */
@ApiModel
public class OrgPermissionDto {
	private String id;
	private String Name;
	private String shortName;
	private String head;
	private List<RoleDto> roles;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<RoleDto> getRoles() {
		if(null == roles){
			roles = new ArrayList<RoleDto>();
		}
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShorName(String shortName) {
		this.shortName = shortName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "OrgPermissionDto [id=" + id + ", Name=" + Name + ", shortName="
				+ shortName + ", head=" + head + ", roles=" + roles + "]";
	}
}
