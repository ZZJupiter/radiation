package com.blackhole.client.service.impl;

import java.util.Date;
import java.util.List;

import com.blackhole.client.dao.DnsMappingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blackhole.client.dao.UserProfileMapper;
import com.blackhole.client.model.UserProfile;
import com.blackhole.client.service.UserProfileService;
import com.blackhole.client.util.AssertUtil;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户自定义dns配置 服务实现类
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-03
 */
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile>
                                    implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private DnsMappingMapper dnsMappingMapper;

    /**
     * 保存用户配置
     * @param userProfile
     */
    @Override
    public void save(UserProfile userProfile) {
        Date currentDate = new Date();
        if (userProfile.getId() == null) {
            userProfile.setCreated(currentDate);
            userProfile.setUpdated(currentDate);
            int insertResult = userProfileMapper.insert(userProfile);
            AssertUtil.state(insertResult > 0, "新增配置成功");
        } else {
            userProfile.setUpdated(currentDate);
            int updateResult = userProfileMapper.updateById(userProfile);
            AssertUtil.state(updateResult > 0, "更新配置成功");
        }
    }

    /**
     * 分页查询用户配置
     * @param creatorList
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<UserProfile> queryByUserName(List<String> creatorList, int currentPage,
                                             int pageSize) {

        Page<UserProfile> page = new Page<>(currentPage, pageSize);
        page.setRecords(userProfileMapper.selectByCreator(creatorList));
        return page;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProfileAndDnsMapping(Long profileId) {
        userProfileMapper.deleteById(profileId);
        dnsMappingMapper.deleteByProfileId(profileId);
    }

}
