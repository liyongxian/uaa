/*
 * Copyright (c) EMCC 2015 All Rights Reserved
 */
package com.hollysys.hiadsp.uaa.controller.role;

import io.swagger.annotations.Api;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.role.RolePermission;
import com.hollysys.hiadsp.common.model.role.RoleRequestParam;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserRole;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.pagination.Page;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.role.GetPageRoleListResponse;
import com.hollysys.hiadsp.uaa.service.RolePermissionService;
import com.hollysys.hiadsp.uaa.service.RoleService;
import com.hollysys.hiadsp.uaa.service.UserRoleService;
import com.hollysys.hiadsp.uaa.service.UserService;

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
@RequestMapping("/role")
@Api(tags={"role-controller"})
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@Autowired
	private UserService userService;
	/**
	 * 获取角色列表
	 */
	@RequestMapping(value = "/getPageRoleList", method = RequestMethod.GET)
	public @ResponseBody GetPageRoleListResponse getPageRoleList(
			@RequestBody RoleRequestParam param) {
		GetPageRoleListResponse response = new GetPageRoleListResponse();
		response.setSuccess(false);
		if (param == null) {
			response.setMsg("参数不能为空");
			response.setErrno("101");
			return response;
		}
		User user = getCurrentUser();
		if (user == null) {
			response.setMsg("登录超时，请重新登录");
			response.setSuccess(false);
			return response;
		}
		Page<Role> page = new Page<Role>();
		page.setPageNo(param.getPageNo());
		page.setPageSize(param.getPageSize());
		if (param.getParentCode() != null && !"".equals(param.getParentCode())) {
			roleService.getPageRoleListByParent(param, page);
		} else {
			List<String> parentCodeList = userRoleService.getRoleCodeList(user
					.getCode());
			if (parentCodeList == null || parentCodeList.size() == 0) {
				response.setMsg("获取角色列表失败");
				response.setErrno("601");
				response.setSuccess(false);
				response.setPage(page);
				return response;
			}
			param.setParentCodeList(parentCodeList);
			roleService.getPageRoleListByParentList(param, page);
		}
		response.setPage(page);
		response.setSuccess(true);
		response.setMsg("获取角色列表成功");
		return response;
	}

	/**
	 * 添加角色信息
	 * 
	 * @param role
	 *            角色信息
	 * @return 响应信息
	 */
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public @ResponseBody BaseResponse addRole(@RequestBody Role role) {
		BaseResponse response = new BaseResponse();
		if (role == null) {
			response.setSuccess(false);
			response.setMsg("参数不能为空");
			response.setErrno("101");
			return response;
		}
		User user = this.getCurrentUser();
		if (user == null) {
			response.setSuccess(false);
			response.setMsg("登录超时，请重新登录");
			response.setErrno("101");
			return response;
		}
		role.setCode(CodeUtil.getLongCode());
		role.setCreator(user.getCode());
		role.setCreateTime(new Date());
		role.setUpdator(user.getCode());
		role.setUpdateTime(new Date());
		int result = this.roleService.addRole(role);
		if (result > 0) {
			response.setSuccess(true);
			response.setMsg("添加成功");
		} else {
			response.setSuccess(false);
			response.setMsg("添加失败");
		}
		return response;
	}

	/**
	 * 编辑角色信息
	 * 
	 * @param role
	 *            角色信息
	 * @return 响应信息
	 */
	@RequestMapping(value = "/editRole", method = RequestMethod.POST)
	public @ResponseBody BaseResponse editRole(@RequestBody Role role) {
		BaseResponse response = new BaseResponse();
		if (role == null) {
			response.setSuccess(false);
			response.setMsg("参数不能为空");
			response.setErrno("101");
			return response;
		}
		User user = this.getCurrentUser();
		if (user == null) {
			response.setSuccess(false);
			response.setMsg("登录超时，请重新登录");
			response.setErrno("101");
			return response;
		}
		if (role.getCode() == null || "".equals(role.getCode())) {
			response.setSuccess(false);
			response.setMsg("参数不能为空");
			response.setErrno("101");
			return response;
		}
		role.setUpdator(user.getCode());
		role.setUpdateTime(new Date());
		int result = this.roleService.saveRole(role);
		if (result > 0) {
			response.setSuccess(true);
			response.setMsg("编辑成功");
		} else {
			response.setSuccess(false);
			response.setMsg("编辑失败");
		}
		return response;
	}

	/**
	 * 根据角色标识，删除角色信息
	 * 
	 * @param code
	 *            角色标识
	 * @return 响应信息
	 */
	@RequestMapping(value = "/delRole", method = RequestMethod.GET)
	public @ResponseBody BaseResponse delRole(@RequestParam("code") String code) {
		BaseResponse result = new BaseResponse();
		List<UserRole> userRoleList = userRoleService
				.getUserRoleListByRole(code);
		if (userRoleList != null && userRoleList.size() > 0) {
			result.setSuccess(false);
			result.setMsg("删除失败，存在和角色关联的用户。");
			return result;
		}
		List<RolePermission> rolePermissionList = rolePermissionService
				.getRolePermissionListByRole(code);
		if (rolePermissionList != null && rolePermissionList.size() > 0) {
			result.setSuccess(false);
			result.setMsg("删除失败，存在和角色关联的权限。");
			return result;
		}
		roleService.delRole(code);
		result.setSuccess(true);
		result.setMsg("删除成功。");
		return result;
	}

	/**
	 * 根据角色标识获取角色
	 * 
	 * @param id
	 *            角色标识
	 * @return 角色信息
	 */
	@RequestMapping(value = "/getRole", method = RequestMethod.GET)
	public @ResponseBody BaseResponse getRole(@RequestParam("code") String code) {
		BaseResponse response = new BaseResponse();
		if (StringUtils.isBlank(code)) {
			response.setSuccess(false);
			response.setMsg("参数不能为空");
			response.setErrno("101");
			return response;
		}
		Role role = this.roleService.getRole(code);
		response.setSuccess(true);
		response.setObj(role);
		response.setMsg("获取角色成功");
		return response;
	}
	
	/**
	 * 根据当前登录人获取其可分配的角色列表
	 */
	@RequestMapping(value="/getRoleListByCurrentUser",method=RequestMethod.GET)
	public @ResponseBody BaseResponse getRoleListByCurrentUser(){
		BaseResponse result = new BaseResponse();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userService.getUserByLoginName(name);
		String code = user.getCode();
		List<String> roleCodeList = this.userRoleService.getRoleCodeList(code);
		HashSet<Role> hs=new HashSet<Role>();
		if(roleCodeList!=null&&roleCodeList.size()>0){
			for (String string : roleCodeList) {
				List<Role> roleListByParent = roleService.getRoleListByParent(string);
				hs.addAll(roleListByParent);
			}
		}
		result.setSuccess(true);
		result.setObj(hs);
		result.setMsg("查询成功!");
		return result;
	}
}
