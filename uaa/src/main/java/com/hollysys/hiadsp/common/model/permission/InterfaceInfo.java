package com.hollysys.hiadsp.common.model.permission;

import java.util.Date;

public class InterfaceInfo {
    private String code;

    private String name;
    
    private String ename;

    private String appType;

    private String needCheck;// 是否需要权限验证

    private String resUri;// 路径

    private String parentCode;// 父节点ID

    private String parentName;// 父节点名称

    private String state;// 状态

    private Integer orderNo;// 排序

    private String permValue;

    private Integer level;

    private String isLeaf;// 是否

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

    public String getNeedCheck() {
	return needCheck;
    }

    public void setNeedCheck(String needCheck) {
	this.needCheck = needCheck;
    }

    public String getResUri() {
	return resUri;
    }

    public void setResUri(String resUri) {
	this.resUri = resUri;
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
