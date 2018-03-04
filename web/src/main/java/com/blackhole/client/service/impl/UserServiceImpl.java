package com.blackhole.client.service.impl;

import com.blackhole.client.dao.UserMapper;
import com.blackhole.client.model.User;
import com.blackhole.client.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
