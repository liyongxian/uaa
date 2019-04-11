package com.hollysys.hiadsp.common.model.permission;

import java.util.Date;

public class Permission {
    public static final String RES_TYPE_MENU = "1";
    public static final String RES_TYPE_ELEMENT = "2";
    public static final String RES_TYPE_INTERFACE = "3";

    public static final String APP_TYPE_WEB = "01";
    public static final String APP_TYPE_CONSOLE = "02";

    public static final String STATE_VALID = "1";
    public static final String STATE_INVALID = "0";

    private String code;

    private String name;
    
    private String ename;

    private String appType;

    private String resType;

    private String resSubType;

    private String resUri;

    private String parentCode;

    private String parentName;

    private String resource;

    private String state;

    private Integer orderNo;

    private String permValue;

    private Integer level;

    private String isLeaf;

    private String description;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;
    
    private int selected;

    

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
	this.name = name == null ? null : name.trim();
    }

    public String getAppType() {
	return appType;
    }

    public void setAppType(String appType) {
	this.appType = appType == null ? null : appType.trim();
    }

    public String getResType() {
	return resType;
    }

    public void setResType(String resType) {
	this.resType = resType == null ? null : resType.trim();
    }

    public String getResSubType() {
	return resSubType;
    }

    public void setResSubType(String resSubType) {
	this.resSubType = resSubType == null ? null : resSubType.trim();
    }

    public String getResUri() {
	return resUri;
    }

    public void setResUri(String resUri) {
	this.resUri = resUri == null ? null : resUri.trim();
    }


    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getResource() {
	return resource;
    }

    public void setResource(String resource) {
	this.resource = resource == null ? null : resource.trim();
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state == null ? null : state.trim();
    }

    public Integer getOrderNo() {
	return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
	this.orderNo = orderNo;
    }

    public String getPermValue() {
	return permValue;
    }

    public void setPermValue(String permValue) {
	this.permValue = permValue == null ? null : permValue.trim();
    }

    public Integer getLevel() {
	return level;
    }

    public void setLevel(Integer level) {
	this.level = level;
    }

    public String getIsLeaf() {
	return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
	this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description == null ? null : description.trim();
    }

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Date getUpdateTime() {
	return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
    }

    public String getParentName() {
	return parentName;
    }

    public void setParentName(String parentName) {
	this.parentName = parentName;
    }

    public String getCreator() {
	return creator;
    }

    public void setCreator(String creator) {
	this.creator = creator;
    }

    public String getUpdator() {
	return updator;
    }

    public void setUpdator(String updator) {
	this.updator = updator;
    }

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getEname() {
	    return ename;
	}

	public void setEname(String ename) {
	    this.ename = ename;
	}
	
}