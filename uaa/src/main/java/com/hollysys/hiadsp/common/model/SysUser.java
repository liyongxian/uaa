package com.hollysys.hiadsp.common.model;

import java.util.Date;

/**
 * 
 * <p>
 * 用户模型类。
 * <p>
 * 
 * 创建日期 2015年8月29日<br>
 * 
 * @author $kangkai$
 *         <p>
 * @since 1.0.0
 */
public class SysUser extends BaseEntity {
	private static final long serialVersionUID = 1L;
	public static final String USER_STATUS_CLOSE = "0";// 账户状态 关闭
	public static final String USER_STATUS_UNACTIVATION = "1";// 账户状态 未激活
	public static final String USER_STATUS_ENABLE = "2";// 账户状态 启用
	private String name;// 用户姓名
	private String loginName;// 登录名
	private String password;// 密码
	private String newPassword;// 密码
	private boolean rememberMe;// 是否记住用户
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	private String mobile;// 手机
	private String email;// 邮件
	private String graphicUrl;// 图片路径
	private String status; // 账户状态
	private String creator; // 创建人
	private Date createTime; // 创建时间
	private String updateUser; // 更新人
	private Date updateTime; // 更新时间
	private boolean admin = false;//是否为平台管理员
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGraphicUrl() {
		return graphicUrl;
	}

	public void setGraphicUrl(String graphicUrl) {
		this.graphicUrl = graphicUrl;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "name: " + name + ",password: " + password + ",sex: " + sex
				+ ",address: " + address + ",id: " + getId();
	}

	public boolean isRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	
	
}
