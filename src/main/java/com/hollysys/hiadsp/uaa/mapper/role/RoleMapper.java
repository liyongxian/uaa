package com.hollysys.hiadsp.uaa.mapper.role;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hollysys.hiadsp.common.model.RoleMenu;
import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.uaa.pagination.Page;
@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(String code);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String code);
    List<Role> selectByPrimaryKeys(List<String> codes);
    List<Role> selectByParent(String parentCode);
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
     * 根据角色标识号获取角色
     * 
     * @param code
     *            角色标识
     * @return 角色信息
     */
    public Role get(String code);

    /**
     * 根据查询条件获取符合的角色集合
     * 
     * @param param
     *            查询条件
     * @return 获取符合的角色集合
     */
    public List<Role> getRoleList(HashMap<String, String> param);

    /**
     * 获取所有的角色集合
     * 
     * @return 所有的角色集合
     */
    public List<Role> getAllRoleList();

    /**
     * 根据用户标识查询该用户具有的角色集合
     * 
     * @param userCode
     *            用户标识
     * @return 该用户具有的角色集合
     */
    public List<Role> getRolesByUserCode(String userCode);

    /**
    * 根据用户标识查询该用户具有的角色集合
    * 
    * @param loginName
    *            用户登录名
    * @return 该用户具有的角色集合
    */
    public List<Role> getRolesByLoginName(String loginName);

    /**
     * 根据查询条件获取 角色的分页
     * 
     * @param filter
     *            查询条件
     * @param page
     *            分页
     * @return 角色集合
     */
    public List<Role> getPageRoleList(String filter, Page<Role> page);

    /**
     * 新增角色信息
     * 
     * @param role
     *            角色信息
     * @return 操作响应标识
     */
    public int addRole(Role role);

    /**
     * 新增角色菜单关系信息
     * 
     * @param roleMenu
     *            角色菜单
     * @return 操作响应标识
     */
    public int addRoleMenu(RoleMenu roleMenu);

    /**
     * 编辑角色信息
     * 
     * @param role
     *            角色信息
     * @return 操作响应标识
     */
    public int editRole(Role role);

    /**
     * 删除角色信息
     * 
     * @param code
     *            角色标识
     * @return 操作响应标识
     */
    public int delRole(String code);

    /**
     * 删除角色和菜单的关系
     * 
     * @param roleCode
     *            角色标识
     * @return 操作响应标识
     */
    public int delRoleMenusByRoleCode(String roleCode);
    
    
    /**
     * 根据菜单编号获取该菜单关联的角色
     * 
     * @param menuCode
     *            菜单标识
     * @return 操作响应标识
     */
    public List<Role> getRolesByMenuCode(String menuCode);
}