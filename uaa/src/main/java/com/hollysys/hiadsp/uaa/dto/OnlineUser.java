package com.hollysys.hiadsp.uaa.dto;

import java.util.Date;

/**
 * 
 * <p>
 * 在线用户值对象。
 * <p>
 *
 * 创建日期 2015年8月29日<br>
 * @author  $kangkai$<p>
 * @since  1.0.0
 */
public class OnlineUser {
    private String sessionId;// 会话标识
    private String name;// 用户姓名
    private String loginName;// 登录名
    private String mobile;// 手机
    private String email;// 邮件
    private Date regTime; // 注册时间
    private String regSource;// 注册来源
    private String regIp;
    private String accessHost;// 访问主机
    private Date loginTime;// 登录时间
    private Date lastAccessTime;// 最近访问时间

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getAccessHost() {
        return accessHost;
    }

    public void setAccessHost(String accessHost) {
        this.accessHost = accessHost;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public int hashCode() {
        return loginName.hashCode();
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == null)
            return false;
        if (this == anObject)
            return true;
        if (anObject instanceof OnlineUser) {
            OnlineUser onlineUser = (OnlineUser) anObject;
            return this.getLoginName().equals(onlineUser.getLoginName());
        }
        return false;
    }
}
