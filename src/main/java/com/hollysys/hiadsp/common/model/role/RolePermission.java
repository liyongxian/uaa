package com.hollysys.hiadsp.common.model.role;

public class RolePermission {
    private String code;

    private String roleCode;

    private String permCode;

    private String optView;

    private String optPass;

    private String optEdit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public String getPermCode() {
        return permCode;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    public String getOptView() {
        return optView;
    }

    public void setOptView(String optView) {
        this.optView = optView == null ? null : optView.trim();
    }

    public String getOptPass() {
        return optPass;
    }

    public void setOptPass(String optPass) {
        this.optPass = optPass == null ? null : optPass.trim();
    }

    public String getOptEdit() {
        return optEdit;
    }

    public void setOptEdit(String optEdit) {
        this.optEdit = optEdit == null ? null : optEdit.trim();
    }
}