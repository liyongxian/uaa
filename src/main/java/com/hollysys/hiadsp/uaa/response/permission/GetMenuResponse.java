package com.hollysys.hiadsp.uaa.response.permission;

import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetMenuResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private MenuInfo menuInfo;
	public MenuInfo getMenuInfo() {
	    return menuInfo;
	}
	public void setMenuInfo(MenuInfo menuInfo) {
	    this.menuInfo = menuInfo;
	}
	
}
