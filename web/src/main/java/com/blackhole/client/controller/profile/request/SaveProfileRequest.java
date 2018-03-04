package com.blackhole.client.controller.profile.request;

import java.util.Date;

/**
 * @author 张钟
 * @date 2018/3/3
 */
public class SaveProfileRequest {

    /**
     * 用户自定义配置ID
     */
    private Long   id;
    /**
     * dns配置名称
     */
    private String profileName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 备注
     */
    private String memo;

    /**
     * 参数检查
     * @param request
     */
    public  static void check(SaveProfileRequest request){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
