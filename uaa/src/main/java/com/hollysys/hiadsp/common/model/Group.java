package com.hollysys.hiadsp.common.model;

import java.util.Date;

public class Group {
	/**
	 * 主键唯一标示，组织编码
	 */
	private String id;

	/**
	 * 组织名称
	 */
	private String name;
	
	/**
	 * 组织简称
	 */
	private String shortName;

	/**
	 * 组织描述
	 */
	private String description;

	/**
	 * 组织地址
	 */
	private String address;

	/**
	 * 组织编号
	 */
	private String telephone;

	/**
	 * 组织邮箱地址
	 */
	private String email;

	/**
	 * 创建人编码
	 */
	private String creator;
	
	/**
	 * 创建人neo4jId
	 */
	private String createNeo4jId;

	/**
	 * 管理员
	 */
	private String adminUser;

	/**
	 * 管理员用户名
	 */
	private String adminUserName;

	/**
	 * 管理员头像
	 */
	private String adminUserHead;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 组织状态 0：停用，1：启用
	 */
	private String state;

	/**
	 * 组织类型 0:用户组；1：政府；2：企业；3：学校；4：科研单位；5：金融机构；6：中介
	 */
	private String type;

	/**
	 * neo4j对应的点的id
	 */
	private Integer neo4jId;

	/**
	 * 组织头像
	 */
	private String head;

	/**
	 * 注册号
	 */
	private String regNo;

	/**
	 * 注册地
	 */
	private String city;

	/**
	 * 营业执照
	 */
	private String licence;
	
	/**
	 * 企业简介图片
	 */
	private String descImg;
	
	/**
	 * 企业网址
	 */
	private String url;
	
	/**
	 * 企业视频
	 */
	private String video;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminUserHead() {
		return adminUserHead;
	}

	public void setAdminUserHead(String adminUserHead) {
		this.adminUserHead = adminUserHead;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNeo4jId() {
		return neo4jId;
	}

	public void setNeo4jId(Integer neo4jId) {
		this.neo4jId = neo4jId;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	public String getCreateNeo4jId() {
		return createNeo4jId;
	}

	public void setCreateNeo4jId(String createNeo4jId) {
		this.createNeo4jId = createNeo4jId;
	}
	
	public String getDescImg() {
		return descImg;
	}

	public void setDescImg(String descImg) {
		this.descImg = descImg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", shortName=" + shortName + ", description="
				+ description + ", address=" + address + ", telephone=" + telephone + ", email="
				+ email + ", creator=" + creator + ", createNeo4jId=" + createNeo4jId
				+ ", adminUser=" + adminUser + ", adminUserName=" + adminUserName
				+ ", adminUserHead=" + adminUserHead + ", createTime=" + createTime + ", state="
				+ state + ", type=" + type + ", neo4jId=" + neo4jId + ", head=" + head + ", regNo="
				+ regNo + ", city=" + city + ", licence=" + licence + ", descImg=" + descImg
				+ ", url=" + url + ", video=" + video + "]";
	}
}