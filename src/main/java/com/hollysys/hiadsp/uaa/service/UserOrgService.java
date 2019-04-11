package com.hollysys.hiadsp.uaa.service;

import java.util.List;

import com.hollysys.hiadsp.common.model.org.Org;
import com.hollysys.hiadsp.common.model.org.OrgAttachUser;
import com.hollysys.hiadsp.common.model.user.User;
import com.hollysys.hiadsp.common.model.user.UserOrg;

public interface UserOrgService {
    public String getOrgCodeByUserCode(String userCode);
    public String getRootOrgCodeByUserCode(String userCode);
    public int addUserOrg(UserOrg userOrg);
    public int delUserOrg(String code);
    public int delUserOrgByUserCode(String userCode);
    public int delUserOrgByOrgCode(String orgCode);
    public Org getOrgByUserCode(String userCode);
    public Org getRootOrgByUserCode(String userCode);
    public List<User> getUserListByOrgCode(String orgCode);
    public List<User> getUserListByRootOrgCode(String rootOrgCode);
    public List<String> getUserCodeListByOrgCode(String orgCode);
    public List<String> getUserCodeListByRootOrgCode(String rootOrgCode);
    public List<OrgAttachUser> getOrgAttachUserList(String userCode);
}
