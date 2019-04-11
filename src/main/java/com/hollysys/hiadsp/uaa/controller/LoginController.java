/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

import com.hollysys.hiadsp.common.model.permission.ElementInfo;
import com.hollysys.hiadsp.common.model.permission.MenuInfo;
import com.hollysys.hiadsp.common.model.permission.Permission;
import com.hollysys.hiadsp.common.model.permission.PermissionUtils;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.uaa.dto.MenuTreeBO;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.GetPermitedMenusResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetWebElementsResponse;
import com.hollysys.hiadsp.uaa.response.permission.GetWebMenusResponse;
import com.hollysys.hiadsp.uaa.service.RolePermissionService;
import com.hollysys.hiadsp.uaa.service.UserOrgService;
import com.hollysys.hiadsp.uaa.service.UserRoleService;
import com.hollysys.hiadsp.uaa.service.UserService;

/**
 * 
 * <p>
 * 用户登录功能。
 * <p>
 * 
 * 创建日期 2015年7月2日<br>
 * 
 * @author kangkai@emcc.net.cn
 *         <p>
 * @since 1.0.0
 */
@Controller
@Api(tags = { "login-controller" })
@RequestMapping(value = "/sys")
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@Autowired
	private UserOrgService userOrgService;

	/**
	 * 检测用户名
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/checkname", method = RequestMethod.POST)
	@ApiIgnore
	public @ResponseBody BaseResponse checkUserName(
			@RequestParam("userName") String userName) {
		BaseResponse response = new BaseResponse();
		int usize = userService.checkUserExits(userName);
		if (usize > 0) {
			response.setSuccess(false);
			response.setMsg("用户名已经存在!");
		} else {
			response.setSuccess(true);
			response.setError("用户名可以使用!");
		}
		return response;
	}

	/**
	 * 获取当前用户授权的菜单
	 * 
	 * @param user
	 * @param req
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getPermitedMenus", method = RequestMethod.GET)
	@ApiIgnore
	public @ResponseBody BaseResponse getPermitedMenus() {
		GetPermitedMenusResponse response = new GetPermitedMenusResponse();
		User user = this.getCurrentUser();
		if (user != null) {
			List<MenuInfo> menuInfoList = null;
			List<String> roleCodeList = userRoleService.getRoleCodeList(user
					.getCode());
			List<Permission> permissionList = rolePermissionService
					.getPermissionsByRole(roleCodeList,
							Permission.APP_TYPE_CONSOLE,
							Permission.RES_TYPE_MENU);
			if (!permissionList.isEmpty()) {
				menuInfoList = PermissionUtils
						.permList2MenuList(permissionList);
			}
			List<MenuTreeBO> allList = new ArrayList<MenuTreeBO>();
			if (menuInfoList != null && menuInfoList.size() > 0) {
				for (MenuInfo menuInfo : menuInfoList) {
					allList.add(new MenuTreeBO(menuInfo));
				}
			}

			List<MenuTreeBO> tran = MenuTreeBO.tranAndSort(allList);

			response.setUser(user);
			response.setMenuSet(tran);
			response.setSuccess(true);
		} else {
			response.setUser(null);
			response.setMenuSet(null);
			response.setSuccess(false);
		}

		return response;
	}

	/**
	 * 运营账户查询菜单
	 * 
	 * @param enterpriseCode
	 *            企业编号
	 * @param userCode
	 *            角色编号
	 * @return
	 */
	@ApiOperation(value = "获取用户菜单接口", notes = "获取用户菜单接口")
	@RequestMapping(value = "/getWebMenusByUserCode", method = { RequestMethod.GET })
	public @ResponseBody GetWebMenusResponse getWebMenusByUserCode(
			@ApiParam(name = "用户编号", required = true) @RequestParam(value = "userCode", required = true) String userCode) {
		GetWebMenusResponse resp = new GetWebMenusResponse();
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		List<String> roleIdList = userRoleService.getRoleCodeList(userCode);
		if (roleIdList != null && roleIdList.size() > 0) {
			menuList = rolePermissionService.getWebMenus(roleIdList);
		}
		resp.setMenus(menuList);
		resp.setSuccess(true);
		resp.setMsg("查询用户菜单成功");

		return resp;
	}

	/**
	 * 运营账户查询菜单
	 * 
	 * @param enterpriseCode
	 *            企业编号
	 * @param userCode
	 *            角色编号
	 * @return
	 */
	@ApiOperation(value = "获取用户元素接口", notes = "获取用户元素接口")
	@RequestMapping(value = "/getWebElementsByUserCode", method = { RequestMethod.GET })
	public @ResponseBody GetWebElementsResponse getWebElementsByUserCode(
			@ApiParam(name = "用户编号", required = true) @RequestParam(value = "userCode", required = true) String userCode) {
		GetWebElementsResponse resp = new GetWebElementsResponse();
		List<ElementInfo> elementList = new ArrayList<ElementInfo>();
		List<String> roleCodeList = userRoleService.getRoleCodeList(userCode);
		if (roleCodeList != null && roleCodeList.size() > 0) {
			elementList = rolePermissionService.getWebElements(roleCodeList);
		}
		resp.setElements(elementList);
		resp.setSuccess(true);
		resp.setMsg("查询用户元素成功");

		return resp;
	}
}
