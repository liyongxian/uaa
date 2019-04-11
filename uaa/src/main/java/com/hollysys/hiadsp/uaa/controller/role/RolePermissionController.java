/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.controller.role;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.model.role.RolePermission;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.role.GetRolePermissionListResponse;
import com.hollysys.hiadsp.uaa.service.RolePermissionService;

/**
 * 
 * <p>
 * 功能描述:用于角色操作。
 * <p>
 * 
 * 创建日期 2015年7月6日<br>
 * 
 * @author wanghq
 *         <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/role/permission")
@Api(tags = { "role-permission" })
public class RolePermissionController extends BaseController {
	@Autowired
	private RolePermissionService rolePermissionService;

	@RequestMapping(value = "/addRolePermission", method = RequestMethod.POST)
	public @ResponseBody BaseResponse addRolePermission(
			@RequestBody RolePermission rolePermission) {
		BaseResponse response = new BaseResponse();
		if (rolePermission == null) {
			response.setSuccess(false);
			response.setErrno("101");
			response.setMsg("参数不能为空");
			return response;
		}
		if (StringUtils.isBlank(rolePermission.getCode())) {
			rolePermission.setCode(CodeUtil.getLongCode());
		}
		int result = rolePermissionService.addRolePermission(rolePermission);
		if (result > 0) {
			response.setSuccess(true);
			response.setMsg("添加角色权限成功");
		} else {
			response.setSuccess(false);
			response.setErrno("601");
			response.setMsg("添加角色权限失败");
			response.setError("插入数据库失败");
		}
		return response;
	}

	@RequestMapping(value = "/addRolePermissions", method = RequestMethod.POST)
	public @ResponseBody BaseResponse addRolePermissions(
			@RequestBody List<RolePermission> rolePermissionList,
			@RequestParam("roleCode") String roleCode) {
		BaseResponse response = new BaseResponse();
		if (rolePermissionList == null || rolePermissionList.size() == 0) {
			response.setSuccess(false);
			response.setErrno("101");
			response.setMsg("参数不能为空");
			return response;
		}
		if (StringUtils.isBlank(roleCode)) {
			response.setSuccess(false);
			response.setErrno("101");
			response.setMsg("参数不能为空");
			return response;
		}
		for (RolePermission rolePermission : rolePermissionList) {
			if (StringUtils.isBlank(rolePermission.getCode())) {
				rolePermission.setCode(CodeUtil.getLongCode());
			}
			if (StringUtils.isBlank(rolePermission.getRoleCode())) {
				rolePermission.setRoleCode(roleCode);
			}
		}
		int result = rolePermissionService
				.addRolePermissions(rolePermissionList);
		if (result > 0) {
			response.setSuccess(true);
			response.setMsg("添加角色权限成功");
		} else {
			response.setSuccess(false);
			response.setErrno("601");
			response.setMsg("添加角色权限失败");
			response.setError("插入数据库失败");
		}
		return response;
	}

	@RequestMapping(value = "/getRolePermissions", method = RequestMethod.GET)
	public @ResponseBody GetRolePermissionListResponse getRolePermissions(
			@RequestParam("roleCode") String roleCode,
			@RequestParam("permType") String permType) {
		GetRolePermissionListResponse response = new GetRolePermissionListResponse();
		if (StringUtils.isBlank(roleCode) || StringUtils.isBlank(permType)) {
			response.setSuccess(false);
			response.setErrno("101");
			response.setMsg("参数不能为空");
			return response;
		}
		List<RolePermission> rolePermissionList = rolePermissionService
				.getRolePermissionListByRole(roleCode, permType);
		response.setRolePermissionList(rolePermissionList);
		response.setMsg("查询角色权限成功");
		response.setSuccess(true);
		return response;
	}

	@ApiOperation(value = "获取权限对应角色", notes = "获取权限对应角色")
	@RequestMapping(value = "/getRolePermissionsByPerm", method = RequestMethod.GET)
	public @ResponseBody GetRolePermissionListResponse getRolePermissionsByPerm(
			@ApiParam("权限编码") @RequestParam("permCode") String permCode) {
		GetRolePermissionListResponse response = new GetRolePermissionListResponse();
		if (StringUtils.isBlank(permCode)) {
			response.setSuccess(false);
			response.setErrno("101");
			response.setMsg("参数不能为空");
			return response;
		}
		// User user = getCurrentUser();
		// if (user == null) {
		// response.setSuccess(false);
		// response.setMsg("登录超时，请重新登录");
		// return response;
		// }
		List<RolePermission> rolePermissionList = rolePermissionService
				.getRolePermissionListByPerm(permCode);
		response.setRolePermissionList(rolePermissionList);
		response.setMsg("查询角色权限成功");
		response.setSuccess(true);
		return response;
	}
	@ApiOperation(value = "获取角色对应的权限的url", notes = "根据访问路径判断此路径有没有对应的角色列表")
	@RequestMapping(value = "/seletRoleByPermUrl", method = RequestMethod.GET)
	public @ResponseBody BaseResponse seletRoleByPermUrl(@ApiParam("访问接口地址") @RequestParam("path") String path)
	{
		BaseResponse response = new BaseResponse();
		
		List<String> rolePermissionList = rolePermissionService.seletRoleByPermUrl(path);
		response.setObj(rolePermissionList);
		response.setMsg("查询角色权限成功");
		response.setSuccess(true);
		return response;
	}

}
