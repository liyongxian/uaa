/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.controller.user;

import io.swagger.annotations.Api;

import java.text.ParseException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.common.util.Dateutil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.pagination.Page;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.GetUserResponse;
import com.hollysys.hiadsp.uaa.service.UserService;
import com.hollysys.hiadsp.uaa.util.system.SystemUtil;

@Api(tags = { "user-controller" })
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	// 注册用户服务
	@Autowired
	private UserService userService;

	/**
	 * 获取用户列表
	 * 
	 * @param pageNum
	 *            当前页。可以为空，为空时为第一页,为空或0是时，默认是首页
	 * @param pageSize
	 *            页面大小,为空或0是时，取默认值com.hollysys.hiadsp.uaa.common.Constans.
	 *            SIZE_PER_PAGE
	 * @param filter
	 *            查询条件,为空时取全部，需要过滤的列有：名称、领域、创建人、url
	 * @return 种子列表
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public @ResponseBody GetUserResponse queryUsers(
			@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize,
			@RequestParam(value = "start", required = false) String start,
			@RequestParam(value = "end", required = false) String end,
			@RequestParam(value = "regSource", required = false) String regSource,
			@RequestParam(value = "province", required = false) String province,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "name", required = false) String name) {
		Page<User> page = new Page<User>();
		page.setPageNo(pageNum);
		page.setPageSize(pageSize);

		HashMap<String, Object> querParam = new HashMap<String, Object>();
		try {
			if (start != null && !start.equals("")) {
				querParam.put("start", Dateutil.longToString(new Long(start),
						"yyyy-MM-dd HH:mm:ss"));
			}
			if (end != null && !end.equals("")) {
				querParam.put("end", Dateutil.longToString(new Long(end),
						"yyyy-MM-dd HH:mm:ss"));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (regSource != null && !regSource.equals("")) {
			querParam.put("regSource", regSource);
		}
		if (province != null && !province.equals("")) {
			querParam.put("province", province);
		}
		if (status != null && !status.equals("")) {
			querParam.put("status", status);
		}
		if (name != null && !name.equals("")) {
			querParam.put("name", name);
		}
		userService.getPageUserList(querParam, page);
		GetUserResponse response = new GetUserResponse();
		response.setPage(page);
		response.setSuccess(true);
		return response;
	}

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 *            用户信息
	 * @return 响应信息
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody BaseResponse addUser(@RequestBody User user) {
		BaseResponse baseResponse = new BaseResponse();
		
		
		int count = userService.checkUserExits(user.getLoginname());
		if (count > 0) {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("存在相同的用户，添加失败");
			return baseResponse;
		}
		
		user.setPassword(SystemUtil.entryptPassword(user.getPassword()));
		if (null == user.getCode()) {
			String code = CodeUtil.getLongCode();
			user.setCode(code);
		}
		int con = userService.addUser(user);
		if (con > 0) {
			baseResponse.setSuccess(true);
			baseResponse.setMsg("添加成功");
			baseResponse.setObj(user.getCode());
		} else {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("添加失败");
		}
		return baseResponse;
	}

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 *            用户信息
	 * @return 响应信息
	 */
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public @ResponseBody BaseResponse saveUser(@RequestBody User user) {
		BaseResponse baseResponse = new BaseResponse();
		if (null == user.getCode()) {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("要编辑的用户code不能为空");
			return baseResponse;
		}
		// 修改用户
		baseResponse.setObj(user.getCode());
		if (user.getPassword() != null && !"".equals(user.getPassword())) {
			user.setPassword(SystemUtil.entryptPassword(user.getPassword()));
		}
		int con = userService.editUser(user);
		if (con > 0) {
			baseResponse.setSuccess(true);
			baseResponse.setMsg("修改成功");
		} else {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("修改失败");
		}
		return baseResponse;
	}

	/**
	 * 验证登录名是否有效
	 * 
	 * @param oldLoginName
	 * @param loginName
	 * @return
	 */
	public String checkLoginName(String oldLoginName, String loginName) {
		if (loginName != null && loginName.equals(oldLoginName)) {
			return "true";
		} else if (loginName != null
				&& userService.getUserByLoginName(loginName) == null) {
			return "true";
		}
		return "false";
	}

	/**
	 * 根据用户标识，删除用户信息
	 * 
	 * @param code
	 *            用户编号
	 * @return 响应信息
	 */
	@RequestMapping(value = "/delUser", method = RequestMethod.DELETE)
	public @ResponseBody BaseResponse delUser(@RequestBody User user) {
		BaseResponse baseResponse = new BaseResponse();
		int con = userService.delUser(user.getCode());
		if (con > 0) {

			baseResponse.setSuccess(true);
			baseResponse.setMsg("删除成功");
		} else {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("删除失败");
		}
		return baseResponse;
	}

	/**
	 * 根据用户标识，启用用户
	 * 
	 * @param code
	 *            用户编号
	 * @return 响应信息
	 */
	@RequestMapping(value = "/enableUser", method = RequestMethod.POST)
	public @ResponseBody BaseResponse enableUser(
			@RequestParam(value = "code", required = false) String code) {
		BaseResponse baseResponse = new BaseResponse();
		User user = userService.get(code);
		if (user != null) {
			user.setStatus(User.USER_STATUS_ENABLE);
			userService.editUser(user);
			baseResponse.setSuccess(true);
			baseResponse.setMsg("用户启用成功！");
		} else {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("用户启用失败，用户不存在！");
		}
		return baseResponse;
	}

	/**
	 * 根据用户标识，冻结用户
	 * 
	 * @param code
	 *            用户编号
	 * @return 响应信息
	 */
	@RequestMapping(value = "/freezeUser", method = RequestMethod.POST)
	public @ResponseBody BaseResponse freezeUser(
			@RequestParam(value = "code", required = false) String code) {
		BaseResponse baseResponse = new BaseResponse();
		User user = userService.get(code);
		if (user != null) {
			user.setStatus(User.USER_STATUS_CLOSE);
			userService.editUser(user);
			baseResponse.setSuccess(true);
			baseResponse.setMsg("用户冻结成功！");
		} else {
			baseResponse.setSuccess(false);
			baseResponse.setMsg("用户不存在，用户冻结失败！");
		}
		return baseResponse;
	}

	/**
	 * 根据用户标识获取用户
	 * 
	 * @param code
	 *            用户编号
	 * @return 用户信息
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public @ResponseBody BaseResponse getUser(@RequestParam("code") String code) {
		BaseResponse response = new BaseResponse();
		User user = this.userService.get(code);
		response.setSuccess(true);
		response.setObj(user);
		response.setMsg("获取用户成功");
		return response;
	}
}
