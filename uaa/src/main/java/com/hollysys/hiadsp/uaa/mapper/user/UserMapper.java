package com.hollysys.hiadsp.uaa.mapper.user;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hollysys.hiadsp.common.model.UserRole;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.pagination.Page;
@Mapper
public interface UserMapper {
    int delUser(String code);

    int addUser(User user);

    int insertSelective(User user);

    User get(String code);
    /**
     * 根据用户登录名获取用户
     * @param loginName 用户登录名
     * @return 用户信息
     */
    public User getUserByLoginName(String loginName);
    /**
     * 根据用户手机获取用户
     * @param loginName 用户登录名
     * @return 用户信息
     */
    public User getUserByMobile(String mobile);
    /**
     * 获取用户列表，根据查询条件
     * @param param 查询条件
     * @return 用户列表
     */
    public List<User> getPageUserList(@Param(value = "param") HashMap<String, Object> param, Page<User> page);

    /**
     * 检查是否存在指定登录名的用户
     * @param loginName 登录名
     * @return 操作标识
     */
    public int checkUserExits(String loginName);

    /**
     * 根据用户邮箱获取用户
     * @param loginName 用户登录名
     * @return 用户信息
     */
    public User getUserByEmail(String email);

    int editUser(User record);

    int updateByPrimaryKey(User record);
    int updateByPrimaryKeySelective(User record);
    /**
     * 更新用户密码，根据用户编号
     * @param user
     * @return
     */
    public int updatePasswordByCode(User user);

    /**
     * 更新用户的头像信息
     * @param user 用户信息
     * @return 操作标识
     */
    public int updateGraphicUrl(User user);
    /**
     * 删除用户分配的角色
     * @param code 用户编号
     * @return 操作标识
     */
    public int delAssignedRoles(String code);

    /**
     * 保存分配给用户的角色
     * @param userRole 用户角色
     * @return 操作标识
     */
    public int saveAssignedRole(UserRole userRole);

    /**
     * 根据角色标识获取具有该角色的所有用户
     * @param roleCode 角色编号
     * @return 用户列表
     */
    public List<User> getUsersByRoleCode(String roleCode);
    
    public List<User> selectByUserCodeList(List<String> userCodeList);
}