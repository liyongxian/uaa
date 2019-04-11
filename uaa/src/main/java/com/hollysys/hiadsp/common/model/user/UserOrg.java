package com.hollysys.hiadsp.common.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户与公司关系")
public class UserOrg {
	@ApiModelProperty(value="编号", position=1)
    private String code;
	@ApiModelProperty(value="用户编号", position=1)
    private String userCode;
	@ApiModelProperty(value="公司编号", position=1)
    private String orgCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

}