package com.hollysys.hiadsp.uaa.config.oauth;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.hollysys.hiadsp.uaa.util.system.SystemUtil;

public class DbPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return SystemUtil.entryptPassword(rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return SystemUtil.validatePassword(rawPassword.toString(),
				encodedPassword.toString());
	}
}
