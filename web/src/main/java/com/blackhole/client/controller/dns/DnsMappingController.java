package com.blackhole.client.controller.dns;

import com.baomidou.mybatisplus.plugins.Page;
import com.blackhole.client.controller.dns.request.QueryDnsMappingForm;
import com.blackhole.client.controller.dns.request.SaveDnsForm;
import com.blackhole.client.controller.dns.request.ShowEditForm;
import com.blackhole.client.convert.DnsConvert;
import com.blackhole.client.model.DnsMapping;
import com.blackhole.client.result.ResultVO;
import com.blackhole.client.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackhole.client.service.DnsMappingService;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * dns映射 前端控制器
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-04
 */
@Controller
@RequestMapping("/dnsMapping")
public class DnsMappingController {

    @Autowired
    private DnsMappingService dnsMappingService;

    /**
     * 进入编辑DNS记录页面
     * @param form
     * @return
     */
    @RequestMapping("/edit.htm")
    public String showEditPage(ShowEditForm form,Model model){
        model.addAttribute("form",form);
        DnsMapping dnsMapping = new DnsMapping();
        if(form.getDnsMappingId()!=null){
            dnsMapping = dnsMappingService.selectById(form.getDnsMappingId());
        }
        model.addAttribute("dnsMapping", dnsMapping);
        return "dns/edit";
    }

    /**
     * 保存dns记录
     * @param saveDnsForm
     * @return
     */
    @RequestMapping(value = "/save.htm")
    public String saveDnsMapping(SaveDnsForm saveDnsForm){

        //参数检查
        SaveDnsForm.check(saveDnsForm);

        DnsMapping dnsMapping = DnsConvert.convert(saveDnsForm);

        dnsMappingService.save(dnsMapping);

        return "redirect:list.htm?profileId="+saveDnsForm.getProfileId();
    }

    /**
     * 展示配置的dns映射列表
     * @param form
     * @param model
     * @return
     */
    @RequestMapping(value = "/list.htm")
    public String showDnsListPage(QueryDnsMappingForm form, Model model) {

        model.addAttribute("form",form);

        Page<DnsMapping> page = dnsMappingService.queryByProfile(form.getProfileId(), form.getCurrentPage(),
            form.getPageSize());

        model.addAttribute("page",page);

        return "dns/list";
    }

    /**
     * 删除dns mapping
     * @param dnsMappingId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public ResultVO deleteDnsMapping(Long dnsMappingId){
        AssertUtil.notNull(dnsMappingId,"dns映射Id为空");
        dnsMappingService.deleteById(dnsMappingId);
        return ResultVO.success();
    }

}
