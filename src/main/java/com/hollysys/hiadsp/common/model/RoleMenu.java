package com.hollysys.hiadsp.common.model;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    private String menuCode;// 用户编号
    private String roleCode;// 角色编号

    public RoleMenu() {}

    public RoleMenu(String roleCode, String menuCode) {
        this.menuCode = menuCode;
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "menuCode: " + menuCode + ",roleCode: " + roleCode;
    }
}
