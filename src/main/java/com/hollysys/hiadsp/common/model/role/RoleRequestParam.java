package com.hollysys.hiadsp.common.model.role;

import java.util.List;

public class RoleRequestParam extends Role {
    public static final int DEFAULT_PAGE_SIZE = 20;
	private int pageNo = 1; // 当前页, 默认为第1页
	private int pageSize = DEFAULT_PAGE_SIZE; // 每页记录数
	private int numPages = 1;
	private String orderBy = "";
	private boolean orderByReverse = false;
	private String filter = "";// 关键字查询
	private List<String> parentCodeList;
	public int getPageNo() {
	    return pageNo;
	}
	public void setPageNo(int pageNo) {
	    this.pageNo = pageNo;
	}
	public int getPageSize() {
	    return pageSize;
	}
	public void setPageSize(int pageSize) {
	    this.pageSize = pageSize;
	}
	public int getNumPages() {
	    return numPages;
	}
	public void setNumPages(int numPages) {
	    this.numPages = numPages;
	}
	public String getOrderBy() {
	    return orderBy;
	}
	public void setOrderBy(String orderBy) {
	    this.orderBy = orderBy;
	}
	public boolean isOrderByReverse() {
	    return orderByReverse;
	}
	public void setOrderByReverse(boolean orderByReverse) {
	    this.orderByReverse = orderByReverse;
	}
	public List<String> getParentCodeList() {
	    return parentCodeList;
	}
	public void setParentCodeList(List<String> parentCodeList) {
	    this.parentCodeList = parentCodeList;
	}
	public String getFilter() {
	    return filter;
	}
	public void setFilter(String filter) {
	    this.filter = filter;
	}
	
}
