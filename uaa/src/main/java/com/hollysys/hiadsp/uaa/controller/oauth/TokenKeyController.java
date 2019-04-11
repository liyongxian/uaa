package com.hollysys.hiadsp.uaa.controller.oauth;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hollysys.hiadsp.uaa.controller.BaseController;
import com.hollysys.hiadsp.uaa.oauth.token.CustomJwtAccessTokenConverter;
@RestController
public class TokenKeyController extends BaseController {
    @Autowired(required=false)
    private CustomJwtAccessTokenConverter converter;
    @Value("${aa}")
    private String aa;

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal user) {
	return user;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
	return aa;
    }
    @RequestMapping(value = "/token_key", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getKey(Principal principal) {
	if ((principal == null || principal instanceof AnonymousAuthenticationToken) && !converter.isPublic()) {
	    throw new AccessDeniedException("You need to authenticate to see a shared key");
	}
	Map<String, String> result = converter.getKey();
	return result;
    }
}
