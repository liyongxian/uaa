package com.hollysys.hiadsp.uaa.controller.oauth;

import io.swagger.annotations.Api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.model.oauth.OauthClient;
import com.hollysys.hiadsp.uaa.response.BaseResponse;
import com.hollysys.hiadsp.uaa.response.oauth.OauthClientResponse;
import com.hollysys.hiadsp.uaa.response.oauth.OauthClientsResponse;
import com.hollysys.hiadsp.uaa.service.oauth.OauthClientService;

@Controller
@Api(tags = { "oauth-client-controller" })
@RequestMapping("/oauth/client")
public class OauthClientController extends BaseController {
    @Autowired
    private OauthClientService oauthClientService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    BaseResponse addOauthClient(@RequestBody OauthClient oauthClient) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (oauthClient == null || StringUtils.isEmpty(oauthClient.getClientId())) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	if (!oauthClientService.checkOauthClient(oauthClient.getClientId())) {
	    response.setSuccess(false);
	    response.setMsg("clientId已经存在");
	    return response;
	}
	int result = oauthClientService.addOauthClient(oauthClient);
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
    BaseResponse deleteOauthClient(@RequestParam String clientId) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (StringUtils.isEmpty(clientId)) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	int result = oauthClientService.deleteById(clientId);
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
    BaseResponse updateOauthClient(@RequestBody OauthClient oauthClient) {

	BaseResponse response = new BaseResponse();
	response.setSuccess(false);

	if (oauthClient == null || StringUtils.isEmpty(oauthClient.getClientId())) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	int result = oauthClientService.updateOauthClient(oauthClient);
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
    OauthClientResponse getOauthClient(@RequestParam String clientId) {

	OauthClientResponse response = new OauthClientResponse();
	response.setSuccess(false);

	if (StringUtils.isEmpty(clientId)) {
	    response.setSuccess(false);
	    response.setMsg("参数不能为空");
	    return response;
	}
	OauthClient oauthClient = oauthClientService.getOauthClientById(clientId);
	if (oauthClient != null) {
	    response.setSuccess(true);
	    response.setMsg("获取成功");
	    response.setOauthClient(oauthClient);
	} else {
	    response.setSuccess(false);
	    response.setMsg("获取失败");
	}
	return response;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    OauthClientsResponse getOauthClientList() {

	OauthClientsResponse response = new OauthClientsResponse();
	response.setSuccess(false);

	List<OauthClient> oauthClients = oauthClientService.getOauthClientList();
	response.setSuccess(true);
	response.setMsg("获取成功");
	response.setOauthClients(oauthClients);
	return response;
    }
}
