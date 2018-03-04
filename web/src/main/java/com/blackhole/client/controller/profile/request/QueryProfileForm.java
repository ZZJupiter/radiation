package com.blackhole.client.controller.profile.request;

import com.blackhole.client.request.PageRequest;

/**
 * @author 张钟
 * @date 2018/3/4
 */
public class QueryProfileForm extends PageRequest {

    private String userNameList;

    public String getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(String userNameList) {
        this.userNameList = userNameList;
    }
}
