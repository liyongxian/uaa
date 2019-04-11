package com.hollysys.hiadsp.uaa.response.permission;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetElementListResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<ElementInfo> elementList;
	public List<ElementInfo> getElementList() {
	    return elementList;
	}
	public void setElementList(List<ElementInfo> elementList) {
	    this.elementList = elementList;
	}
	
}
