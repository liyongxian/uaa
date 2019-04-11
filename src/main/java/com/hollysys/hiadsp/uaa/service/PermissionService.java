package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.permission.dto.MenuDto;
import com.hollysys.hiadsp.common.model.permission.dto.OrgPermissionDto;
import com.hollysys.hiadsp.common.model.permission.dto.RoleDto;

public interface PermissionService {
    /**
     * 获取所有权限列表
     * 
     * @return 权限列表
     */
    public List<Permission> getAllPermissionList();
    
    /**
     * 获取所有权限列表
     * 
     * @return 权限列表
     */
    public List<Permission> getPermissionList(String appType,String resType,String resSubType);
    /**
     * 根据权限ID获取权限详情
     * 
     * @param id
     * @return 权限信息
     */
    public Permission getPermission(String id);
    
    /**
     * 根据父节点标识获取孩子节点
     * 
     * @param parentId
     *            父节点编号
     * @return 孩子节点集合
     */
    public List<Permission> getChildren(String parentId);
    
    /**
     * 添加权限
     * 
     * @param permission
     *            权限信息
     * @return 响应标识
     */
    public int addPermission(Permission permission);

    /**
     * 编辑权限
     * 
     * @param permission
     *            权限信息
     * @return 响应标识
     */
    public int editPermission(Permission permission);

    /**
     * 根据权限标识删除权限
     * 
     * @param id
     *            权限标识
     * @return 响应标识
     */
    public int delPermission(String id);

    /**
     * 根据角色标识获取角色相关的权限
     * 
     * @param roleCode
     *            角色标识
     * @return 菜单集合
     */
    public List<Permission> getPermissionsByRoleCode(String roleCode);
    
    /**
     * 根据查询条件获取权限集合
     * 
     * @param param
     *            查询条件
     * @return 菜单集合
     */
    public List<Permission> getPermissionsByLoginName(String loginName);
    
    public int updateLeafState(String id,String isLeaf);
    
    /**
     * 获取用户权限列表(简化版)。<br>
     * 用于web、app、ucenter进行权限查看使用。
     * @param userCode
     * @param needInterface 是否需要获取接口信息
     * @return
     * @throws ChangedigException 
     */
    public List<OrgPermissionDto> getUerPermissions(String userCode,boolean needInterface);
    
    /**
     * 获取用户在某一企业中权限（简化版）<br>
     * 用于web、app、ucenter进行权限查看使用。
     * @param enterpriseCode 组织Id
     * @param userCode 用户编号
     * @param needInterface 是否需要获取接口
     * @return
     */
    public List<RoleDto> getUserPermission(String enterpriseCode,String userCode,boolean needInterface);
    
    /**
     * 运营账户超级账户获取所有菜单
     * @return
     */
    List<MenuDto> getAllMenus();
}
