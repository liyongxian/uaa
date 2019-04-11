package com.hollysys.hiadsp.uaa.response.user;

import java.util.List;

import com.hollysys.hiadsp.common.model.user.UserRole;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetUserRoleListResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    List<UserRole> userRoleList;

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

}
