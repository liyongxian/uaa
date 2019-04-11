package com.hollysys.hiadsp.uaa.response.permission;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.InterfaceInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetInterfaceListResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<InterfaceInfo> interfaceList;
	public List<InterfaceInfo> getInterfaceList() {
	    return interfaceList;
	}
	public void setInterfaceList(List<InterfaceInfo> interfaceList) {
	    this.interfaceList = interfaceList;
	}
	
}
