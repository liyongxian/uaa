package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.role.RolePermission;

public interface RolePermissionService {
    /**
     * 获取角色对应的菜单
     * @param roleCode 角色编号
     * @return
     */
    public List<MenuInfo> getWebMenus(String roleCode);
    /**
     * 获取角色对应的菜单
     * @param roleCode 角色编号列表
     * @return
     */
    public List<MenuInfo> getWebMenus(List<String> roleCodeList);
    /**
     * 获取角色对应的元素
     * @param roleCodeList 角色编号列表
     * @return
     */
    public List<ElementInfo> getWebElements(List<String> roleCodeList);
    /**
     * 获取角色对应的元素
     * @param roleCode 角色编号
     * @return
     */
    public List<ElementInfo> getWebElements(String roleCode);
    
    public int addRolePermissions(List<RolePermission> rolePermissionList);
    public int addRolePermission(RolePermission rolePermission);
    public int delRolePermissionByRole(String roleCode);
    
    public List<RolePermission> getRolePermissionListByRole(String roleCode);
    public List<RolePermission> getRolePermissionListByRole(String roleCode, String permissionType);
    
    public List<RolePermission> getRolePermissionListByPerm(String permCode);
    
    public List<Permission> getPermissionsByRole(String roleCode,String appType,String resType);
    public List<Permission> getPermissionsByRole(List<String> roleCodeList,String appType,String resType);
    public List<Permission> getPermissionsByRole(String roleCode,String appType,String resType,String subType);
    public List<Permission> getPermissionsByRole(List<String> roleCodeList,String appType,String resType,String subType);
    public List<String>     seletRoleByPermUrl(String url);
}
