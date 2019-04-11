package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.role.RoleRequestParam;
import com.hollysys.hiadsp.uaa.pagination.Page;

public interface RoleService {
    /**
     * 增加角色
     * @param role
     * @return
     */
    public int addRole(Role role);
    /**
     * 编辑角色
     * @param role
     * @return
     */
    public int saveRole(Role role);
    /**
     * 获取角色详情
     * @param code
     * @return
     */
    public Role getRole(String code);
    /**
     * 删除角色
     * @param code
     * @return
     */
    public int delRole(String code);
    /**
     * 获取直接下级角色列表
     * @param parentCode
     * @return
     */
    public List<Role> getRoleListByParent(String parentCode);
    /**
     * 获取直接下级角色列表
     * @param parentCode
     * @return
     */
    public List<Role> getRoleListByParentList(List<String> parentCodeList);
    /**
     * 分页获取直接下级角色列表
     * @param parentCode
     * @return
     */
    public List<Role> getPageRoleListByParent(RoleRequestParam param,Page<Role> page);
    /**
     * 分页获取直接下级角色列表
     * @param parentCode
     * @return
     */
    public List<Role> getPageRoleListByParentList(RoleRequestParam param,Page<Role> page);
}
