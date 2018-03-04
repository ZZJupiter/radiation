package com.blackhole.client.controller.dns.request;

import com.blackhole.client.util.AssertUtil;

/**
 * @author 张钟
 * @date 2018/3/4
 */
public class SaveDnsForm {

    /** dns映射ID **/
    private Long id;

    /** 配置ID **/
    private Long   profileId;

    /** ip 地址 **/
    private String ip;

    /** 域名 **/
    private String domain;

    /** 备注信息 **/
    private String memo;

    public static void check(SaveDnsForm form){
        AssertUtil.notNull(form,"保存dns表单对象为空");
        AssertUtil.notNull(form.getProfileId(),"所属配置为空");
        AssertUtil.notNull(form.getIp(),"IP地址为空");
        AssertUtil.notNull(form.getDomain(),"域名为空");
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
