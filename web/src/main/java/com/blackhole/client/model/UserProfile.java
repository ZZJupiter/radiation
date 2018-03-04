package com.blackhole.client.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 用户自定义dns配置
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-03
 */
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户自定义配置ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long              id;
    /**
     * dns配置名称
     */
    private String            profileName;
    /**
     * 创建人
     */
    private String            creator;
    /**
     * 创建时间
     */
    private Date              created;
    /**
     * 更新时间
     */
    private Date              updated;
    /**
     * 备注
     */
    private String            memo;

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
        return "UserProfile{" + ", id=" + id + ", profileName=" + profileName + ", creator="
               + creator + ", created=" + created + ", memo=" + memo + "}";
    }
}
