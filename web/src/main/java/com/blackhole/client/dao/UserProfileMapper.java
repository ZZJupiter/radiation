package com.blackhole.client.dao;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.blackhole.client.model.UserProfile;

/**
 * <p>
 * 用户自定义dns配置 Mapper 接口
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-03
 */
public interface UserProfileMapper extends BaseMapper<UserProfile> {

    /**
     * 通过创建人查询用户配置
     * @param creatorList
     * @return
     */
    List<UserProfile> selectByCreator(@Param("creatorList") List<String> creatorList);

}
