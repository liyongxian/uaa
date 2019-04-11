package com.hollysys.hiadsp.common.model.permission.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class InterfaceDto {
	private String id;			// 标识
    private String name; 		// 名称
    private String needCheck;	// 是否需要权限验证
    private String resUri;		// 路径
    private String state;		// 状态  1：有效；0：无效
    private String permValue;	// permission
    private String description;	// 描述
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
	/*
	 *@see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof InterfaceDto){
			InterfaceDto temp = (InterfaceDto)obj;
			if(this.id == temp.getId() && this.name.equals(temp.getName())
					&& this.resUri.equals(temp.getResUri()) && this.permValue.equals(temp.getPermValue())){
				return true;
			}else{
				return false;
			}
		
		}
		return false;
		
	}
	
	@Override
	public String toString() {
		return "InterfaceDto [id=" + id + ", name=" + name + ", needCheck="
				+ needCheck + ", resUri=" + resUri + ", state=" + state
				+ ", permValue=" + permValue + ", description=" + description
				+ "]";
	}
	
}
