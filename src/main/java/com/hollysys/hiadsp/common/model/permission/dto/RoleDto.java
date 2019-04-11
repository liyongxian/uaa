package com.hollysys.hiadsp.common.model.permission.dto;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

@ApiModel
public class RoleDto {
	private String id;			// 标识
	private String name;		// 名称	
	private String eName;		// 英文名称
	private String state;		// 名称
	private String description;	// 描述
	private List<ElementDto> elements;		// 元素列表
	private List<InterfaceDto> interfaces;	// 接口列表
	
	/**
	 * 
	 */
	public RoleDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param eName
	 * @param state
	 * @param description
	 */
	public RoleDto(String id, String name, String eName, String state,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.eName = eName;
		this.state = state;
		this.description = description;
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
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ElementDto> getElements() {
		if(null == elements){
			elements = new ArrayList<ElementDto>();
		}
		return elements;
	}
	public void setElements(List<ElementDto> elements) {
		this.elements = elements;
	}
	public List<InterfaceDto> getInterfaces() {
		if(null ==  interfaces){
			interfaces = new ArrayList<InterfaceDto>();
		}
		return interfaces;
	}
	public void setInterfaces(List<InterfaceDto> interfaces) {
		this.interfaces = interfaces;
	}
	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", name=" + name + ", eName=" + eName
				+ ", state=" + state + ", description=" + description
				+ ", elements=" + elements + ", interfaces=" + interfaces + "]";
	}	
	
}
