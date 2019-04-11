package com.hollysys.hiadsp.uaa.config.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.uaa.service.UserRoleService;
import com.hollysys.hiadsp.uaa.service.UserService;

public class DbUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
	com.hollysys.hiadsp.common.model.user.User dbUser = userService.getUserByLoginName(userCode);
	// .get(userCode);

	if (null != dbUser) {
		
		//如果用户状态不为“可用”状态
		if(!dbUser.getStatus().equals(com.hollysys.hiadsp.common.model.user.User.USER_STATUS_ENABLE))
		{
			return null;
		}
	    //获取用户角色
	    List<Role> roleList = userRoleService.getRoleListByUser(dbUser.getCode());
	    Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
	    if(roleList != null && roleList.size() > 0){
		for(Role role : roleList){
		    if(role != null && StringUtils.isNotEmpty(role.getEname()) ){
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role.getEname().toUpperCase());
			auths.add(authority);
		    }
		}
	    }else{
		// 给一个默认角色
		    GrantedAuthority defaultAuth = new SimpleGrantedAuthority("ROLE_USER");
		    auths.add(defaultAuth);
	    }
	    
	    User user = new User(userCode, dbUser.getPassword(), true, true, true, true, auths);

	    return user;
	}

	return null;
    }
}
