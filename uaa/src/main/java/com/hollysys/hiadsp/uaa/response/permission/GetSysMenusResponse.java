package com.hollysys.hiadsp.uaa.response.permission;

import java.util.ArrayList;
import java.util.List;

import com.hollysys.hiadsp.common.model.permission.dto.MenuDto;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetSysMenusResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<MenuDto> menus;
	/**
	 * @return the menus
	 */
	public List<MenuDto> getMenus() {
		return menus;
	}
	
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<MenuDto> menus) {
		if(null == menus){
			menus = new ArrayList<MenuDto>();
		}
		this.menus = menus;
	}
}
