package com.hollysys.hiadsp.uaa.dto;

public class UserDTO {
	private String code;
	private String name;
	private String graphicUrl;
	
	public UserDTO() {}
	
	
	/**
	 * @param code
	 * @param name
	 * @param graphicUrl
	 */
	public UserDTO(String code, String name, String graphicUrl) {
		super();
		this.code = code;
		this.name = name;
		this.graphicUrl = graphicUrl;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the graphicUrl
	 */
	public String getGraphicUrl() {
		return graphicUrl;
	}
	/**
	 * @param graphicUrl the graphicUrl to set
	 */
	public void setGraphicUrl(String graphicUrl) {
		this.graphicUrl = graphicUrl;
	}
	
	
}
