package com.blackhole.client.controller.dns.request;

/**
 * @author 张钟
 * @date 2018/3/4
 */
public class ShowEditForm {

    /** dns映射ID **/
    private Long dnsMappingId;

    /** 所属配置ID **/
    private Long profileId;

    public Long getDnsMappingId() {
        return dnsMappingId;
    }

    public void setDnsMappingId(Long dnsMappingId) {
        this.dnsMappingId = dnsMappingId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
