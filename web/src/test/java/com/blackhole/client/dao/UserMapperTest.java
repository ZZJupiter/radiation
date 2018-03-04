package com.blackhole.client.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.blackhole.client.model.User;
import com.blackhole.client.model.UserProfile;
import com.blackhole.client.service.UserProfileService;

/**
 * @author 张钟
 * @date 2018/2/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper         userMapper;

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void test() {
        User user = new User();
        user.setAge(1);
        user.setCreated(new Date());
        user.setUserName("姓名");
        int insertResult = userMapper.insert(user);
        System.out.println(insertResult);
    }

    @Test
    public void test_select() {
        List<User> userList = userMapper.selectByName("姓名");
        System.out.println(userList);
    }

    @Test
    public void test_queryOnePage() {
        List<String> creators = new ArrayList<>();
        creators.add("简一");
        Page<UserProfile> page = userProfileService.queryByUserName(creators, 1, 10);
        System.out.println(page);
    }

}
