package com.hollysys.hiadsp.uaa.service;

import java.util.HashMap;
import java.util.List;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.pagination.Page;

/**
 * 用户服务类，用于提供用户的业务操作方法
 * 
 * @author kangkai
 */
public interface UserService {
    // 用户相关缓存
    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_CODE_ = "code_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";

    /**
     * 得到登录用户
     * 
     * @param code 用户编号
     * 
     * @return 用户信息
     */
    public User get(String code);

    /**
     * 根据用的登录名，检查改用户是否存在
     * 
     * @param loginName
     *            登录名
     * @return 是否存在。0:不存在;1:存在
     */
    public int checkUserExits(String loginName);

    /**
     * 根据登录用户名得到用户
     * 
     * @param loginName 登录用户名
     * 
     * @return 用户信息
     */
    public User getUserByLoginName(String loginName);

    /**
     * 根据手机得到用户
     * 
     * @param mobile 手机
     * 
     * @return 用户信息
     */
    public User getUserByMobile(String mobile);

    /**
     * 根据邮箱获取用户
     * 
     * @param email 手机
     * 
     * @return 用户信息
     */
    public User getUserByEmail(String email);
    
    public List<User> getUserList(HashMap<String, String> param);
    
    
    public List<User> selectByUserCodeList(List<String> codes);

    /**
     * 
     * @param param
     * @param page
     * @return
     */
    public List<User> getPageUserList(HashMap<String, Object> param, Page<User> page);

    /**
     * 新增用户
     * 
     * @param user
     *            用户信息
     * @return 成功标识
     */
    public int addUser(User user);

    /**
     * 编辑用户
     * 
     * @param user
     *            用户信息
     * @return 成功标识
     */
    public int editUser(User user);

    /**
     * 删除用户
     * 
     * @param code
     *            用户标识
     * @return 成功标识
     */
    public int delUser(String code);

    /**
     * 修改用户密码
     * 
     * @param userCode 用户编号
     * 
     * @param loginName 登录名称
     * @param newPassword 新密码
     * @return 成功标识
     */
    public void updatePasswordByCode(String userCode, String loginName, String newPassword);

    /**
     * 修改用户头像路径
     * 
     * @param user 用户信息
     * 
     * @return 成功标识
     */
    public void updateGraphicUrl(User user);

}
