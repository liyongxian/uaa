package com.hollysys.hiadsp.common.model;
/**
 * 
 * <p>
 *   类型(科技动态,论文)。
 * <p>
 *
 * 创建日期 2015年8月31日<br>
 * @author  $litong$<p>
 * @since  1.0.0
 */
public class Type extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private String num;// 名称
	private String type_name;// 名称
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
}
