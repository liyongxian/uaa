package com.hollysys.hiadsp.uaa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.mapper.role.RoleMapper;
import com.hollysys.hiadsp.uaa.mapper.user.UserMapper;
import com.hollysys.hiadsp.uaa.pagination.Page;
import com.hollysys.hiadsp.uaa.service.UserService;
import com.hollysys.hiadsp.uaa.util.system.SystemUtil;

/**
 * 用户服务类，用于提供用户的业务操作方法
 * 
 * @author kangkai
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int checkUserExits(String userName) {
		return userMapper.checkUserExits(userName);
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回 new User()
	 */
	public User getCurrentUser() {
		// TODO 修改
		return null;
	}

	@Override
	public User get(String code) {
		return userMapper.get(code);
	}

	@Override
	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
	}

	@Override
	public User getUserByMobile(String mobile) {
		return userMapper.getUserByMobile(mobile);
	}

	@Override
	public User getUserByEmail(String email) {
		return userMapper.getUserByEmail(email);
	}

	@Override
	public List<User> getPageUserList(HashMap<String, Object> param,
			Page<User> page) {
		List<User> users = userMapper.getPageUserList(param, page);
		return users;
	}

	@Override
	public int addUser(User user) {
		user.setCreatetime(new Date());
		user.setUpdatetime(new Date());
		user.setStatus("2");
		user.setDelstatus("0");
		user.setRegip("0.0.0.0");
		user.setRegsource("2");// 0:app1:web2:console
		if (null != user.getBirthday()) {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(user
					.getBirthday()));
		}
		return userMapper.insertSelective(user);
	}

	@Override
	public int editUser(User user) {
		if (user.getBirthday() != null) {
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").format(user
					.getBirthday()));
		}
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int delUser(String userId) {
		return userMapper.delUser(userId);
	}

	@Override
	public void updatePasswordByCode(String userCode, String loginName,
			String newPassword) {
		User user = new User();
		user.setCode(userCode);
		user.setLoginname(loginName);
		user.setPassword(SystemUtil.entryptPassword(newPassword));
		userMapper.updatePasswordByCode(user);
	}

	public void updateGraphicUrl(User user) {
		userMapper.updateGraphicUrl(user);
	}

	@Override
	public List<User> getUserList(HashMap<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectByUserCodeList(List<String> codes) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserCodeList(codes);
	}

}
