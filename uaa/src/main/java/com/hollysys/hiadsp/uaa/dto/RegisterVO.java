package com.hollysys.hiadsp.uaa.dto;

/**
 * 
 * <p>
 * 注册传值对象。
 * <p>
 *
 * 创建日期 2015年7月16日<br>
 * @author  $litong$<p>
 * @since  1.0.0
 */
public class RegisterVO {
    private String email;// 邮箱
    private String mobile;// 手机
    private String validCode;// 验证码
    private String oldPassword;// 原密码
    private String newPassword;// 新密码
    private String pass; // 密码
    private String confirm_pass;// 确认密码\

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }
}
