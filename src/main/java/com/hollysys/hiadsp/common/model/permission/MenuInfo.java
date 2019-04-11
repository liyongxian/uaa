package com.hollysys.hiadsp.common.model.permission;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "菜单信息")
public class MenuInfo {
    @ApiModelProperty(value="菜单CODE", required=false)
    private String code;
    @ApiModelProperty(value="菜单名称", required=true)
    private String name;
    @ApiModelProperty(value="菜单英文名称", required=true)
    private String ename;
    @ApiModelProperty(value="应用类型", required=true,notes="应用类型（01：web；02：console）")
    private String appType;// 一级分类（01：web；02：console）
    @ApiModelProperty(value="菜单路由", required=true,notes="菜单路由（例如：app.product）")
    private String routeState;
    @ApiModelProperty(value="父节点CODE", required=false,notes="父节点CODE,为空默认为一级节点")
    private String parentCode;
    @ApiModelProperty(value="父节点名称", required=false)
    private String parentName;
    @ApiModelProperty(value="图标", required=false)
    private String icon;// 资源（如：菜单的图标）
    @ApiModelProperty(value="是否展示", required=false,notes="是否展示（1：展示；0：不展示），默认为1")
    private String isshow;
    @ApiModelProperty(value="排序值", required=true)
    private Integer orderNo;
    @ApiModelProperty(value="菜单权限值", required=true,notes="菜单权限值（例如：role:*:*）")
    private String permValue;
    @ApiModelProperty(value="菜单层级", required=true)
    private Integer level;
    @ApiModelProperty(value="是否叶子节点", required=false)
    private String isLeaf;
    @ApiModelProperty(value="菜单描述", required=false)
    private String description;
    @ApiModelProperty(value="创建时间", required=false)
    private Date createTime;
    @ApiModelProperty(value="创建者ID", required=false)
    private String creator;
    @ApiModelProperty(value="更新时间", required=false)
    private Date updateTime;
    @ApiModelProperty(value="更新者", required=false)
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

    public String getRouteState() {
	return routeState;
    }

    public void setRouteState(String routeState) {
	this.routeState = routeState;
    }

    public String getParentName() {
	return parentName;
    }

    public void setParentName(String parentName) {
	this.parentName = parentName;
    }

    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    public String getIsshow() {
	return isshow;
    }

    public void setIsshow(String isshow) {
	this.isshow = isshow;
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

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
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
