package com.hollysys.hiadsp.uaa.controller.user;

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

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserRole;
import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.GetUserListResponse;
import com.hollysys.hiadsp.uaa.response.user.GetUserPermitedRoleListResponse;
import com.hollysys.hiadsp.uaa.response.user.GetUserRoleListResponse;
import com.hollysys.hiadsp.uaa.service.UserRoleService;

@Controller
@RequestMapping("/user/role")
@Api(tags = { "user-role-controller" })
public class UserRoleController extends BaseController {
    @Autowired
    private UserRoleService userRoleService;
    
    /**
     * 添加用户角色
     * @param userCode
     * @param userRoleList
     * @return
     */
    @RequestMapping(value="/addUserRoles",method=RequestMethod.POST)
    public @ResponseBody BaseResponse addUserRoles(@RequestParam("userCode")String userCode,@RequestBody List<UserRole> userRoleList){
	BaseResponse response = new BaseResponse();
	if(StringUtils.isBlank(userCode)){
	    response.setSuccess(false);
	    response.setErrno("101");
	    response.setMsg("参数不能为空");
	    return response;
	}
	if(userRoleList != null && userRoleList.size() > 0){
	    for(UserRole userRole : userRoleList){
		userRole.setCode(CodeUtil.getLongCode());
		if(StringUtils.isBlank(userRole.getUserCode())){
		    userRole.setUserCode(userCode);
		}
	    }
	}
	int result = userRoleService.addUserRoles(userCode,userRoleList);
	if(result != -1){
	    response.setSuccess(true);
	    response.setMsg("添加用户角色成功");
	}else{
	    response.setSuccess(false);
	    response.setMsg("添加用户角色失败");
	}
	return response;
    }
    /**
     * 查询用户已拥有的角色列表
     * @param userCode
     * @return
     */
    @RequestMapping(value="/getUserRoles",method=RequestMethod.GET)
    public @ResponseBody GetUserRoleListResponse getUserRoles(@RequestParam("userCode")String userCode){
	GetUserRoleListResponse response = new GetUserRoleListResponse();
	if(StringUtils.isBlank(userCode)){
	    response.setSuccess(false);
	    response.setErrno("101");
	    response.setMsg("参数不能为空");
	    return response;
	}
	List<UserRole> userRoleList = userRoleService.getUserRoleListByUser(userCode);
	response.setUserRoleList(userRoleList);
	response.setSuccess(true);
	response.setMsg("获取用户角色成功");
	return response;
    }
    /**
     * 获取用户可分配的角色列表
     * @param userCode
     * @return
     */
    @RequestMapping(value="/getUserPermitedRoles",method=RequestMethod.GET)
    public @ResponseBody GetUserPermitedRoleListResponse getUserPermitedRoles(@RequestParam("userCode")String userCode){
	GetUserPermitedRoleListResponse response = new GetUserPermitedRoleListResponse();
	if(StringUtils.isBlank(userCode)){
	    response.setSuccess(false);
	    response.setErrno("101");
	    response.setMsg("参数不能为空");
	    return response;
	}
	List<Role> roleList = userRoleService.getRoleListByUser(userCode);
	response.setRoleList(roleList);
	response.setSuccess(true);
	response.setMsg("获取用户角色成功");
	return response;
    }
    /**
     * 获取角色下的用户
     * @param userCode
     * @return
     */
    @RequestMapping(value="/getUsersByRole",method=RequestMethod.GET)
    public @ResponseBody GetUserListResponse getUsersByRole(@RequestParam("roleCode")String roleCode){
	GetUserListResponse response = new GetUserListResponse();
	if(StringUtils.isBlank(roleCode)){
	    response.setSuccess(false);
	    response.setErrno("101");
	    response.setMsg("参数不能为空");
	    return response;
	}
	
	List<User> userList = userRoleService.getUserListByRole(roleCode);
	response.setUserList(userList);
	response.setSuccess(true);
	response.setMsg("获取用户成功");
	return response;
    }
    /**
     * 获取角色下的用户
     * @param userCode
     * @return
     */
    @ApiOperation(value = "获取角色下的用户", notes = "获取角色下的用户")
    @RequestMapping(value="/getUsersByRoles",method=RequestMethod.GET)
    public @ResponseBody GetUserListResponse getUsersByRoles(@ApiParam("角色编码列表")@RequestParam("roleCodeList")List<String> roleCodeList){
	GetUserListResponse response = new GetUserListResponse();
	if(roleCodeList == null || roleCodeList.size() == 0){
	    response.setSuccess(false);
	    response.setErrno("101");
	    response.setMsg("参数不能为空");
	    return response;
	}
//	User user = getCurrentUser();
//	if(user == null){
//	    response.setSuccess(false);
//	    response.setMsg("登录超时，请重新登录");
//	    return response;
//	}
	List<User> userList = userRoleService.getUserListByRoleList(roleCodeList);
	response.setUserList(userList);
	response.setSuccess(true);
	response.setMsg("获取用户成功");
	return response;
    }
}
