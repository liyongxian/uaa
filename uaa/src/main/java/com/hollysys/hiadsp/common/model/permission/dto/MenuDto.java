package com.hollysys.hiadsp.common.model.permission.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "菜单简化信息")
public class MenuDto {
	 @ApiModelProperty(value="菜单ID", required=false)
	    private String id;
	    @ApiModelProperty(value="菜单名称", required=true)
	    private String name;
	    @ApiModelProperty(value="菜单英文名称", required=true)
	    private String ename;
	    @ApiModelProperty(value="菜单路由", required=true,notes="菜单路由（例如：app.product）")
	    private String routeState;
	    @ApiModelProperty(value="父节点ID", required=false,notes="父节点ID,为空默认为一级节点")
	    private String parentId;
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
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public String getRouteState() {
			return routeState;
		}
		public void setRouteState(String routeState) {
			this.routeState = routeState;
		}
		public String getParentId() {
			return parentId;
		}
		public void setParentId(String parentId) {
			this.parentId = parentId;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "MenuDto [id=" + id + ", name=" + name + ", ename=" + ename
					+ ", routeState=" + routeState + ", parentId=" + parentId
					+ ", icon=" + icon + ", isshow=" + isshow + ", orderNo="
					+ orderNo + ", permValue=" + permValue + ", level=" + level
					+ ", isLeaf=" + isLeaf + ", description=" + description
					+ "]";
		}
	    
	    
}
