package com.blackhole.client.dao;

import com.blackhole.client.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-02-02
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户名称查询用户
     * @param userName
     * @return
     */
    List<User> selectByName(@Param("userName") String userName);

}
