package com.hollysys.hiadsp.common.model.permission;

import java.util.Date;

public class ElementInfo {
    private String code;

    private String name;
    
    private String ename;

    private String appType;

    private String resSubType;

    private String parentCode;

    private String parentName;

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
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAppType() {
	return appType;
    }

    public void setAppType(String appType) {
	this.appType = appType;
    }

    public String getResSubType() {
	return resSubType;
    }

    public void setResSubType(String resSubType) {
	this.resSubType = resSubType;
    }

    public String getParentName() {
	return parentName;
    }

    public void setParentName(String parentName) {
	this.parentName = parentName;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
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
	this.permValue = permValue;
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
	this.isLeaf = isLeaf;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

}
