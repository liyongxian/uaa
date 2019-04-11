package com.hollysys.hiadsp.uaa.util.system;

import java.security.Principal;

import javax.security.auth.Subject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hollysys.hiadsp.uaa.util.system.security.Digests;

/**
 * 
 * <p>
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单。
 * <p>
 *
 * 创建日期 2015年8月8日<br>
 * 
 * @author $Author$
 *         <p>
 * @since 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SystemUtil {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;
	public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt,
				HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证密码
	 * 
	 * @param plainPassword
	 *            明文密码
	 * @param password
	 *            密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = Encodes.decodeHex(password.substring(0, 16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt,
				HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt)
				+ Encodes.encodeHex(hashPassword));
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		// shiro遗留代码
		return null;
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal() {
		// shiro遗留代码
		return null;
	}
}
