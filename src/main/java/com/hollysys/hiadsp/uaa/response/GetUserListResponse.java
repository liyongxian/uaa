package com.hollysys.hiadsp.uaa.response;

import java.util.List;

import com.hollysys.hiadsp.common.model.user.User;

public class GetUserListResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    

}
