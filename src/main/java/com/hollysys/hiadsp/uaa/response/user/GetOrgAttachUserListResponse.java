package com.hollysys.hiadsp.uaa.response.user;

import java.util.List;

import com.hollysys.hiadsp.common.model.org.OrgAttachUser;
import com.hollysys.hiadsp.uaa.response.BaseResponse;

public class GetOrgAttachUserListResponse extends BaseResponse {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private List<OrgAttachUser> orgList;

    public List<OrgAttachUser> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrgAttachUser> orgList) {
        this.orgList = orgList;
    }
    

}
