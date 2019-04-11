package com.hollysys.hiadsp.uaa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.role.RoleRequestParam;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.mapper.role.RoleMapper;
import com.hollysys.hiadsp.uaa.pagination.Page;
import com.hollysys.hiadsp.uaa.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
	int result = -1;
	if(role == null){
	    logger.error("execute addRole error,role can not be null");
	    return result;
	}
	if(role.getCode() == null || "".equals(role.getCode())){
	    role.setCode(CodeUtil.getLongCode()); 
	}
	if(StringUtils.isEmpty(role.getState())){
	    role.setState("1");
	}
	if(StringUtils.isEmpty(role.getSuperadmin())){
	    role.setSuperadmin("0");
	}
	if(StringUtils.isEmpty(role.getRoleType())){
	    role.setRoleType("1");
	}
	result = roleMapper.insert(role);
	if(result >0){
	    logger.info("execute addRole success,roleCode="+role.getCode()); 
	}else{
	    logger.error("execute addRole error,insert into db error,roleCode="+role.getCode());
	}
	return result;
    }

    @Override
    public int saveRole(Role role) {
	int result = -1;
	if(role == null){
	    logger.error("execute saveRole error,role can not be null");
	    return result;
	}
	if(role.getCode() == null || "".equals(role.getCode())){
	    logger.error("execute saveRole error,roleCode can not be null");
	    return result;
	}
	result = roleMapper.updateByPrimaryKey(role);
	if(result >0){
	    logger.info("execute saveRole success,roleCode="+role.getCode()); 
	}else{
	    logger.error("execute saveRole error,update into db error,roleCode="+role.getCode());
	}
	return result;
    }

    @Override
    public Role getRole(String code) {
	if(code == null || "".equals(code)){
	    logger.error("execute getRole error,code can not be null");
	    return null;
	}
	return roleMapper.selectByPrimaryKey(code);
    }

    @Override
    public int delRole(String code) {
	int result = -1;
	if(code == null || "".equals(code)){
	    logger.error("execute delRole error,code can not be null");
	    return result;
	}
	result = this.delRoleTree(code);
	if(result >0){
	    logger.info("execute delRole success,delnum="+result+"roleCode="+code); 
	}else{
	    logger.warn("execute delRole warn,org does not exist in db,roleCode="+code);
	}
	return result;
    }

    @Override
    public List<Role> getRoleListByParent(String parentCode) {
	List<Role> roleList = new ArrayList<Role>();
	if(parentCode == null || "".equals(parentCode)){
	    logger.error("execute getRoleListByParent erro,parentCode could not be null");
	    return roleList;
	}
	roleList = roleMapper.selectByParent(parentCode);
	return roleList;
    }

    /**
     * 删除自身及下级角色
     * @param orgCode
     * @return
     */
    private int delRoleTree(String roleCode){
	int num = 0;
	if(roleCode == null || "".equals(roleCode)){
	    return num;
	}
	List<Role> childRoleList = roleMapper.selectByParent(roleCode);
	if(childRoleList != null && childRoleList.size() > 0){
	    for(Role role : childRoleList){
		if(role != null && role.getCode() != null && !"".equals(role.getCode())){
		    num += delRoleTree(role.getCode());
		}
	    }
	    
	}else{
	    num += roleMapper.deleteByPrimaryKey(roleCode);
	}
	return num;
    }

    @Override
    public List<Role> getRoleListByParentList(List<String> parentCodeList) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Role> getPageRoleListByParent(RoleRequestParam param, Page<Role> page) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Role> getPageRoleListByParentList(RoleRequestParam param, Page<Role> page) {
	// TODO Auto-generated method stub
	return null;
    }

}
