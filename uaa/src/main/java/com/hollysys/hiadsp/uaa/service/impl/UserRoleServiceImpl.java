package com.hollysys.hiadsp.uaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserRole;
import com.hollysys.hiadsp.uaa.mapper.role.RoleMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserRoleMapper;
import com.hollysys.hiadsp.uaa.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    private static Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Role> getRoleListByUser(String userCode) {
	List<Role> roleList = new ArrayList<Role>();
	if (StringUtils.isBlank(userCode)) {
	    logger.error("execute getRoleList error,userCode can not be null");
	    return roleList;
	}
	List<String> roleCodeList = this.getRoleCodeList(userCode);
	if (roleCodeList != null && roleCodeList.size() > 0) {
	    roleList = roleMapper.selectByPrimaryKeys(roleCodeList);
	    if (roleList != null && roleList.size() > 0) {
		logger.info("execute getRoleList success,roleList.size=" + roleList.size() + ",userCode=" + userCode);
	    } else {
		logger.error("execute getRoleList error,could not find roleList by userCode,userCode=" + userCode);
	    }
	}
	return roleList;
    }

    @Override
    public List<String> getRoleCodeList(String userCode) {
	List<String> roleCodeList = new ArrayList<String>();
	if (StringUtils.isBlank(userCode)) {
	    logger.error("execute getRoleCodeList error,userCode can not be null");
	    return roleCodeList;
	}
	List<UserRole> userRoleList = userRoleMapper.selectByUserCode(userCode);
	if (userRoleList != null && userRoleList.size() > 0) {
	    for (UserRole userRole : userRoleList) {
		roleCodeList.add(userRole.getRoleCode());
	    }
	    logger.info("execute getRoleIdList success,userRoleList.size=" + userRoleList.size() + ",userCode=" + userCode);
	} else {
	    logger.warn("execute getRoleIdList warn,could not find userRole by userCode,userCode=" + userCode);
	}
	return roleCodeList;
    }

    @Override
    public List<UserRole> getUserRoleListByRole(String roleCode) {
	List<UserRole> userRoleList = new ArrayList<UserRole>();
	if (StringUtils.isBlank(roleCode)) {
	    logger.error("execute getUserRoleListByRole error,roleCode can not be null");
	    return userRoleList;
	}
	return userRoleMapper.selectByRoleCode(roleCode);
    }

    @Override
    public int addUserRoles(String userCode,List<UserRole> userRoleList) {
	int result = -1;
	if(StringUtils.isBlank(userCode)){
	    logger.error("execute addUserRoles error,userCode can not be null");
	    return result;
	}
	result = userRoleMapper.deleteByUserCode(userCode);
	if(userRoleList != null && userRoleList.size() > 0){
	   result = userRoleMapper.insertBatch(userRoleList);
	}
	return result;
    }

    @Override
    public List<UserRole> getUserRoleListByUser(String userCode) {
	List<UserRole> userRoleList = new ArrayList<UserRole>();
	if (StringUtils.isBlank(userCode)) {
	    logger.error("execute getUserRoleListByUser error,userCode can not be null");
	    return userRoleList;
	}
	return userRoleMapper.selectByUserCode(userCode);
    }

    @Override
    public List<User> getUserListByRole(String roleCode) {
	List<User> userList = new ArrayList<User>();
	if(StringUtils.isEmpty(roleCode)){
	    logger.error("execute getUserListByRole error,roleCode can not be null");
	    return userList;
	}
	List<String> userCodeList = this.getUserCodeList(roleCode);
	if(userCodeList != null && userCodeList.size() > 0){
	    userList = userMapper.selectByUserCodeList(userCodeList);
	}
	return userList;
    }

    @Override
    public List<User> getUserListByRoleList(List<String> roleCode) {
	List<User> userList = new ArrayList<User>();
	if(roleCode == null || roleCode.size() == 0){
	    logger.error("execute getUserListByRoleList error,roleCode can not be null");
	    return userList;
	}
	List<String> userCodeList = this.getUserCodeList(roleCode);
	if(userCodeList != null && userCodeList.size() > 0){
	    userList = userMapper.selectByUserCodeList(userCodeList);
	}
	return userList;
    }

    @Override
    public List<String> getUserCodeList(String roleCode) {
	List<String> userCodeList = new ArrayList<String>();
	if(StringUtils.isEmpty(roleCode)){
	    logger.error("execute getUserCodeList error,roleCode can not be null");
	    return userCodeList;
	}
	List<UserRole> userRoleList = this.userRoleMapper.selectByRoleCode(roleCode);
	if(userRoleList != null && userRoleList.size() > 0){
	    for(UserRole userRole : userRoleList){
		userCodeList.add(userRole.getUserCode());
	    }
	}else{
	    logger.warn("execute getUserCodeList warn,userRoleMapper.selectByRoleCode returned empty,roleCode="+roleCode);
	}
	return userCodeList;
    }
    @Override
    public List<String> getUserCodeList(List<String> roleCodeList) {
	List<String> userCodeList = new ArrayList<String>();
	if(roleCodeList == null || roleCodeList.size() == 0){
	    logger.error("execute getUserCodeList error,roleCodeList can not be null");
	    return userCodeList;
	}
	List<UserRole> userRoleList = this.userRoleMapper.selectByRoleCodeList(roleCodeList);
	if(userRoleList != null && userRoleList.size() > 0){
	    for(UserRole userRole : userRoleList){
		userCodeList.add(userRole.getUserCode());
	    }
	}else{
	    logger.warn("execute getUserCodeList warn,userRoleMapper.roleCodeList returned empty,roleCodeList="+roleCodeList);
	}
	return userCodeList;
    }

}
