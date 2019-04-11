package com.hollysys.hiadsp.uaa.response.permission;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetElementResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private ElementInfo elementInfo;
	public ElementInfo getElementInfo() {
	    return elementInfo;
	}
	public void setElementInfo(ElementInfo elementInfo) {
	    this.elementInfo = elementInfo;
	}
	
}
