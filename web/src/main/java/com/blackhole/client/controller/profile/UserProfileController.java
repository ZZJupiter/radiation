package com.blackhole.client.controller.profile;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.blackhole.client.controller.dns.vo.DnsMappingVO;
import com.blackhole.client.controller.profile.request.QueryProfileForm;
import com.blackhole.client.controller.profile.request.SaveProfileRequest;
import com.blackhole.client.convert.DnsConvert;
import com.blackhole.client.convert.ProfileConvert;
import com.blackhole.client.integration.blackhole.BlackholeConnector;
import com.blackhole.client.model.DnsMapping;
import com.blackhole.client.model.UserProfile;
import com.blackhole.client.result.ResultVO;
import com.blackhole.client.service.DnsMappingService;
import com.blackhole.client.service.UserProfileService;
import com.blackhole.client.util.AssertUtil;
import com.blackhole.client.util.IPUtils;

/**
 * <p>
 * 用户自定义dns配置 前端控制器
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-03
 */
@Controller
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private BlackholeConnector blackholeConnector;

    @Autowired
    private DnsMappingService  dnsMappingService;

    /**
     * 保存用户dns配置
     * @param request
     * @return
     */
    @RequestMapping(value = "/save.htm")
    public String saveUserProfile(SaveProfileRequest request, Model model) {

        request.setCreator("简一");
        //参数校验
        SaveProfileRequest.check(request);

        //模型转换
        UserProfile userProfile = ProfileConvert.convert(request);

        //保存
        userProfileService.save(userProfile);

        return "redirect:list.htm";

    }

    /**
     * 配置列表页
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/list.htm")
    public String showProfileListPage(QueryProfileForm form, Model model) {

        form.setUserNameList("简一");
        List<String> userNameList = Arrays.asList(form.getUserNameList().split(","));
        Page<UserProfile> page = userProfileService.queryByUserName(userNameList,
            form.getCurrentPage(), form.getPageSize());
        model.addAttribute("page", page);
        model.addAttribute("form", form);

        return "profile/list";
    }

    /**
     * 返回配置项编辑页面
     * @param profileId
     * @return
     */
    @RequestMapping(value = "/edit.htm")
    public String showEditProfilePage(Long profileId,Model model) {
        UserProfile userProfile = new UserProfile();
        if(profileId!=null){
             userProfile = userProfileService.selectById(profileId);
        }
        model.addAttribute("profile",userProfile);
        return "profile/edit";
    }

    /**
     *
     * @param profileId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/activate")
    public ResultVO activateProfile(Long profileId) {
        String ip = IPUtils.getClientIp();
        List<DnsMapping> dnsMappingList = dnsMappingService.queryByProfile(profileId);
        List<DnsMappingVO> dnsMappingVOList = DnsConvert.convert(dnsMappingList);
        boolean result = blackholeConnector.addByIp(ip, dnsMappingVOList);
        AssertUtil.state(result, "激活失败");
        return ResultVO.success();
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public ResultVO deleteProfile(Long profileId){
        AssertUtil.notNull(profileId,"待删除配置Id为空");
        userProfileService.deleteProfileAndDnsMapping(profileId);
        return ResultVO.success();
    }

}
