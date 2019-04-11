package com.hollysys.hiadsp.uaa.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.model.org.OrgAttachUser;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.response.user.GetOrgAttachUserListResponse;
import com.hollysys.hiadsp.uaa.service.OrgService;
import com.hollysys.hiadsp.uaa.service.UserOrgService;

@Controller
@RequestMapping("/user/org")
@Api(tags={"user-org-controller"})
public class UserOrgController extends BaseController {
    @Autowired
    private UserOrgService userOrgService;
    @Autowired
    private OrgService orgService;
    
    @ApiOperation(value = "获取用户组织", notes = "获取用户组织接口")
    @RequestMapping(value="/getUserOrgs",method=RequestMethod.GET)
    public @ResponseBody GetOrgAttachUserListResponse getOrgAttachUserList(@ApiParam(name="用户编号",required=true)@RequestParam("userCode")String userCode){
	GetOrgAttachUserListResponse response = new GetOrgAttachUserListResponse();
	if(userCode == null || "".equals(userCode)){
	    response.setSuccess(false);
	    response.setMsg("获取组织架构失败");
	    response.setError("参数不能为空");
	    response.setErrno("101");
	    return response;
	}
	List<OrgAttachUser> orgAttachUserList = userOrgService.getOrgAttachUserList(userCode);
	if(orgAttachUserList == null || orgAttachUserList.size() == 0){
	    response.setSuccess(false);
	    response.setMsg("获取组织架构失败");
	    response.setError("获取用户根组织失败");
	    response.setErrno("601");
	}else{
	    response.setSuccess(true);
	    response.setMsg("获取组织架构成功");
	    response.setOrgList(orgAttachUserList);
	}
	return response;
    }
    
    
}
