package com.hollysys.hiadsp.uaa.response.permission;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetMenuListResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<MenuInfo> menuList;
	public List<MenuInfo> getMenuList() {
	    return menuList;
	}
	public void setMenuList(List<MenuInfo> menuList) {
	    this.menuList = menuList;
	}
}
