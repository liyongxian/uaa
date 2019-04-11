/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.response.role;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.uaa.pagination.Page;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

/**
 * <p>
 * 功能描述,该部分必须以中文句号结尾。
 * <p>
 * 
 * @author kangkai
 * @since 1.0.0
 */
public class GetPageRoleListResponse extends BaseResponse {
	//
	private static final long serialVersionUID = 1L;
	private Page<Role> page;

	public Page<Role> getPage() {
		return page;
	}

	public void setPage(Page<Role> page) {
		this.page = page;
	}
}
