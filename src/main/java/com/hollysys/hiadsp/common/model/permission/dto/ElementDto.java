package com.hollysys.hiadsp.common.model.permission.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class ElementDto {
    private String id;			// 标识
    private String name;		// 名称
    private String ename;		// 英文简称
    private String state;		// 状态 1：有效；0：无效
    private String permValue;	// permission
    private String description;	// 描述
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPermValue() {
		return permValue;
	}
	public void setPermValue(String permValue) {
		this.permValue = permValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override	
	public boolean equals(Object obj) {
		if(obj instanceof ElementDto){
			ElementDto temp = (ElementDto)obj;
			if(this.id == temp.getId() && this.name.equals(temp.getName())
					&& this.permValue.equals(temp.getPermValue())){
				return true;
			}else{
				return false;
			}
		
		}
		return false;
		
	}
	@Override
	public String toString() {
		return "ElementDto [id=" + id + ", name=" + name + ", state=" + state
				+ ", permValue=" + permValue + ", description=" + description
				+ "]";
	}	
}
