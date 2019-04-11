package com.hollysys.hiadsp.uaa.controller.oauth;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.common.util.CodeUtil;
import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.model.oauth.OauthResource;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.oauth.OauthResourceResponse;
import com.hollysys.hiadsp.uaa.response.oauth.OauthResourcesResponse;
import com.hollysys.hiadsp.uaa.service.oauth.OauthResourceService;

@Controller
@RequestMapping("/oauth/resource")
public class OauthResourceController extends BaseController {
    @Autowired
    private OauthResourceService oauthResourceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse addOauthResource(@RequestBody OauthResource oauthResource) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (oauthResource == null || StringUtils.isEmpty(oauthResource.getName())) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	oauthResource.setCode(CodeUtil.getLongCode());
	int result = oauthResourceService.add(oauthResource);
	if (result > 0) {
	    response.setSuccess(true);
	    response.setMsg("添加成功");
	} else {
	    response.setSuccess(false);
	    response.setMsg("添加失败");
	}
	return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public @ResponseBody
    BaseResponse deleteOauthResource(@RequestParam String code) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (StringUtils.isEmpty(code)) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	int result = oauthResourceService.deleteByCode(code);
	if (result > 0) {
	    response.setSuccess(true);
	    response.setMsg("删除成功");
	} else {
	    response.setSuccess(false);
	    response.setMsg("删除失败");
	}
	return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse updateOauthResource(@RequestBody OauthResource oauthResource) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (oauthResource == null || StringUtils.isEmpty(oauthResource.getCode())) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	int result = oauthResourceService.update(oauthResource);
	if (result > 0) {
	    response.setSuccess(true);
	    response.setMsg("更新成功");
	} else {
	    response.setSuccess(false);
	    response.setMsg("更新失败");
	}
	return response;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    OauthResourceResponse getOauthResource(@RequestParam String code) {

	OauthResourceResponse response = new OauthResourceResponse();
	response.setSuccess(false);

	if (StringUtils.isEmpty(code)) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	OauthResource oauthResource = oauthResourceService.getByCode(code);
	if (oauthResource != null) {
	    response.setSuccess(true);
	    response.setMsg("获取成功");
	    response.setOauthResource(oauthResource);
	} else {
	    response.setSuccess(false);
	    response.setMsg("获取失败");
	}
	return response;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    OauthResourcesResponse getOauthResourceList() {

	OauthResourcesResponse response = new OauthResourcesResponse();
	response.setSuccess(false);

	List<OauthResource> oauthResources = oauthResourceService.getAll();
	response.setSuccess(true);
	response.setMsg("获取成功");
	response.setOauthResources(oauthResources);
	return response;
    }
}
