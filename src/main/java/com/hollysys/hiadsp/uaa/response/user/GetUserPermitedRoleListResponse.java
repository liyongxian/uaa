package com.hollysys.hiadsp.uaa.response.user;

import java.util.List;

import com.hollysys.hiadsp.common.model.role.Role;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetUserPermitedRoleListResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
}
