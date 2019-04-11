/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.response;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.pagination.Page;

/**
 * <p>
 * 功能描述,该部分必须以中文句号结尾。
 * <p>
 * 
 * @author kangkai
 * @since 1.0.0
 */
public class GetUserResponse extends BaseResponse {
	//
	private static final long serialVersionUID = 1L;
	private Page<User> page;
	// 用户基本信息
	private User user;

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
