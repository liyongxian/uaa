package com.hollysys.hiadsp.uaa.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.service.UserService;

public class BaseController {
    @Autowired
    private UserService userService;
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected User getCurrentUser()
    {
	Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
	String loginName = "";
	Object principal = authentication.getPrincipal();
	if (principal instanceof UserDetails) {
	    loginName = ((UserDetails) principal).getUsername();
	}
	else if (principal instanceof Principal) {
	    loginName = ((Principal) principal).getName();
	}else{
	    loginName = principal.toString();
	}
	User user = userService.getUserByLoginName(loginName);
	return user;
    }
}
