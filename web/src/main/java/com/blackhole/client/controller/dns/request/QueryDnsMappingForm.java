package com.blackhole.client.controller.dns.request;

import com.blackhole.client.request.PageRequest;

/**
 * @author 张钟
 * @date 2018/3/4
 */
public class QueryDnsMappingForm extends PageRequest{

    private Long profileId;

    private String ip;

    private String domain;

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIp() {

        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
