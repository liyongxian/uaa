package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserRole;

public interface UserRoleService {
    /**
     * 获取用户已拥有的角色列表
     * @param userCode
     * @return
     */
    public List<Role> getRoleListByUser(String userCode);
    /**
     * 获取用户有用的角色编码列表
     * @param userCode
     * @return
     */
    public List<String> getRoleCodeList(String userCode);
    public List<UserRole> getUserRoleListByRole(String roleCode);
    public List<UserRole> getUserRoleListByUser(String userCode);
    public int addUserRoles(String userCode,List<UserRole> userRoleList);
    
    public List<User> getUserListByRole(String roleCode);
    
    public List<User> getUserListByRoleList(List<String> roleCode);
    
    public List<String> getUserCodeList(String roleCode);
    
    public List<String> getUserCodeList(List<String> roleCodeList);
}
