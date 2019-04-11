package com.hollysys.hiadsp.common.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "用户详细信息") 
public class User {
    public static final String USER_STATUS_CLOSE = "0";// 账户状态 关闭
    public static final String USER_STATUS_UNACTIVATION = "1";// 账户状态 未激活
    public static final String USER_STATUS_ENABLE = "2";// 账户状态 启用
    @ApiModelProperty(value="编号", position=1)
    private String code;
    @ApiModelProperty(value="姓名", position=2)
    private String name;
    @ApiModelProperty(value="登陆账号", position=3)
    private String loginname;
    @ApiModelProperty(value="密码", position=4)
    private String password;
    @ApiModelProperty(value="新密码", position=5)
    private String newPassword;// 密码
    @ApiModelProperty(value="地址", position=6)
    private String address;
    @ApiModelProperty(value="省份", position=7)
    private String province;
    @ApiModelProperty(value="城市", position=8)
    private String city;
    @ApiModelProperty(value="性别0：未知；1：男；2：女", position=9)
    private String sex;
    @ApiModelProperty(value="出生年月", position=10)
    private String birthday;
    @ApiModelProperty(value="电话", position=11)
    private String mobile;
    @ApiModelProperty(value="介绍", position=12)
    private String introduction;
    @ApiModelProperty(value="邮箱", position=13)
    private String email;
    @ApiModelProperty(value="头像", position=14)
    private String graphicurl;
    @ApiModelProperty(value="注册时间", position=15)
    private Date regtime;
    @ApiModelProperty(value="注册来源0：app / 1：web", position=16)
    private String regsource;
    @ApiModelProperty(value="注册ip", position=17)
    private String regip;
    @ApiModelProperty(value="注册地址", position=18)
    private String regaddress;
    @ApiModelProperty(value="状态0:关闭；1:启用; 2：未审核", position=19)
    private String status;
    @ApiModelProperty(value="删除状态0：正常；-1：已删除", position=20)
    private String delstatus;
    @ApiModelProperty(value="登陆时间", position=21)
    private Date logintime;
    @ApiModelProperty(value="更新人员", position=22)
    private String updateuser;
    @ApiModelProperty(value="更新时间", position=23)
    private Date updatetime;
    @ApiModelProperty(value="创建者编码", position=24)
    private String creator;
    @ApiModelProperty(value="创建时间", position=25)
    private Date createtime;
    @ApiModelProperty(value="token", position=26)
    private String token;
    @ApiModelProperty(value="省名称", position=27)
    private String provinceName;
    @ApiModelProperty(value="城市名称", position=28)
    private String cityName;
    @ApiModelProperty(value="超时还见", position=29)
    private String tokenexptime;
    @ApiModelProperty(value="兴趣爱好，两个兴趣以逗号分隔", position=30)
    private String hobby;

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGraphicurl() {
        return graphicurl;
    }

    public void setGraphicurl(String graphicurl) {
        this.graphicurl = graphicurl == null ? null : graphicurl.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getRegsource() {
        return regsource;
    }

    public void setRegsource(String regsource) {
        this.regsource = regsource == null ? null : regsource.trim();
    }

    public String getRegip() {
        return regip;
    }

    public void setRegip(String regip) {
        this.regip = regip == null ? null : regip.trim();
    }

    public String getRegaddress() {
        return regaddress;
    }

    public void setRegaddress(String regaddress) {
        this.regaddress = regaddress == null ? null : regaddress.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getTokenexptime() {
        return tokenexptime;
    }

    public void setTokenexptime(String tokenexptime) {
        this.tokenexptime = tokenexptime == null ? null : tokenexptime.trim();
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
    
}