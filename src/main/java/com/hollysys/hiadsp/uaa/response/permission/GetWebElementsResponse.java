package com.hollysys.hiadsp.uaa.response.permission;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetWebElementsResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;	 
	private List<ElementInfo> elements;
	public List<ElementInfo> getElements() {
	    return elements;
	}
	public void setElements(List<ElementInfo> elements) {
	    this.elements = elements;
	}
	
}
