package com.hollysys.hiadsp.common.model;

import java.io.Serializable;

public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userCode;// 用户编号
    private String roleCode;// 角色编号

    public UserRole() {}

    public UserRole(String userCode, String roleCode) {
        this.userCode = userCode;
        this.roleCode = roleCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return "userCode: " + userCode + ",roleCode: " + roleCode;
    }
}
