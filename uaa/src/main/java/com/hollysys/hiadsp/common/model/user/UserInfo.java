package com.hollysys.hiadsp.common.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户信息") 
public class UserInfo {
	@ApiModelProperty(value="编号", position=1)
	private String code;
	@ApiModelProperty(value="姓名", position=2)
	private String name;
	@ApiModelProperty(value="职位", position=3)
	private String post;
	@ApiModelProperty(value="工位编号", position=4)
	private String jobNumber;
	@ApiModelProperty(value="分机", position=5)
	private String extension;
	@ApiModelProperty(value="传真", position=6)
	private String fax;
	@ApiModelProperty(value="用户所在城市", position=7)
	private String cityName;
	@ApiModelProperty(value="手机", position=8)
	private String mobile;
	@ApiModelProperty(value="邮箱", position=9)
	private String email;
	@ApiModelProperty(value="地址", position=10)
	private String address;
	@ApiModelProperty(value="生日", position=11)
	private String birthday;
	@ApiModelProperty(value="爱好", position=12)
	private String hobby;
	@ApiModelProperty(value="头像", position=13)
	private String graphicUrl;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getGraphicUrl() {
		return graphicUrl;
	}
	public void setGraphicUrl(String graphicUrl) {
		this.graphicUrl = graphicUrl;
	}
	

}
