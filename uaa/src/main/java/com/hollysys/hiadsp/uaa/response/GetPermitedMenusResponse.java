/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.response;

import java.util.List;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.dto.MenuTreeBO;

/**
 * <p>
 * 功能描述,该部分必须以中文句号结尾。
 * <p>
 * 
 * @author kangkai
 * @since 1.0.0
 */
public class GetPermitedMenusResponse extends BaseResponse {
	//
	private static final long serialVersionUID = 1L;
	private List<MenuTreeBO> menuSet;
	private User user;

    public List<MenuTreeBO> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(List<MenuTreeBO> menuSet) {
        this.menuSet = menuSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
