package com.hollysys.hiadsp.uaa.response.permission;

import java.util.ArrayList;
import java.util.List;

import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetWebMenusResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<MenuInfo> menus;
	/**
	 * @return the menus
	 */
	public List<MenuInfo> getMenus() {
		return menus;
	}
	
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<MenuInfo> menus) {
		if(null == menus){
			menus = new ArrayList<MenuInfo>();
		}
		this.menus = menus;
	}
}
