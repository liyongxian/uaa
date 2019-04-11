package com.hollysys.hiadsp.common.model;

/**
 * 
 * <p>
 * 菜单模型类。
 * <p>
 * 
 * 创建日期 2015年7月13日<br>
 * 
 * @author $litong$
 *         <p>
 * @since 1.0.0
 */
public class Menu extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String parentName;// 父菜单名称
    private String parentCode;// 父菜单标识
    private String name;// 菜单名称
    private String href;// 菜单路径
    private int sort;// 排序
    private String icon;// 菜单图标
    private String isshow;// 是否展示
    private String permission;// 许可
    private String creatorId;// 创建人
    private String createDate;// 创建
    private String remarks;
    private String routeState;// 路由
    
    public void setRouteState(String routeState) {
		this.routeState = routeState;
	}
    
    public String getRouteState() {
		return routeState;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
