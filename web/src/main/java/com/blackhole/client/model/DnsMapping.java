package com.blackhole.client.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * dns映射
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-04
 */
@TableName("dnsMapping")
public class DnsMapping implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 映射ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 所属配置ID
     */
    @TableField("profileId")
    private Long profileId;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 域名
     */
    private String domain;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;
    /**
     * 备注
     */
    private String memo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "DnsMapping{" +
        ", id=" + id +
        ", profileId=" + profileId +
        ", ip=" + ip +
        ", domain=" + domain +
        ", created=" + created +
        ", memo=" + memo +
        "}";
    }
}
