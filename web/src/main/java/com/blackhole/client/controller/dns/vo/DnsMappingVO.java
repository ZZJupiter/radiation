package com.blackhole.client.controller.dns.vo;

/**
 * @author 张钟
 * @date 2018/3/3
 */
public class DnsMappingVO {

    /** ip 地址 **/
    private String ip;

    /** 对应的域名 **/
    private String domain;

    /** 备注 **/
    private String memo;



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
}
