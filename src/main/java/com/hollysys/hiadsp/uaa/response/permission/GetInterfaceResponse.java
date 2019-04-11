package com.hollysys.hiadsp.uaa.response.permission;

import com.hollysys.hiadsp.common.model.permission.InterfaceInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetInterfaceResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private InterfaceInfo InterfaceInfo;
	public InterfaceInfo getInterfaceInfo() {
	    return InterfaceInfo;
	}
	public void setInterfaceInfo(InterfaceInfo interfaceInfo) {
	    InterfaceInfo = interfaceInfo;
	}
	
}
