package com.blackhole.client.convert;

import com.blackhole.client.controller.profile.request.SaveProfileRequest;
import com.blackhole.client.model.UserProfile;
import com.blackhole.client.util.bean.BeanUtils;

/**
 * @author 张钟
 * @date 2018/3/3
 */
public class ProfileConvert {

    public static UserProfile convert(SaveProfileRequest request){
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(request,userProfile);
        return userProfile;
    }
}
