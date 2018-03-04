package com.blackhole.client.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.blackhole.client.model.UserProfile;

/**
 * <p>
 * 用户自定义dns配置 服务类
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-03
 */
public interface UserProfileService extends IService<UserProfile> {

    /**
     * 保存用户配置
     * @param userProfile
     */
    void save(UserProfile userProfile);

    /**
     * 通过创建人查询配置列表
     * @param creatorList
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<UserProfile> queryByUserName(List<String> creatorList, int currentPage, int pageSize);

    /**
     * 删除配置文件,同时删除对应的dns映射数据
     * @param profileId
     */
    void deleteProfileAndDnsMapping(Long profileId);

}
