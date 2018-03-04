package com.blackhole.client.controller.dns;

import com.alibaba.fastjson.JSONArray;
import com.blackhole.client.controller.dns.vo.DnsMappingVO;
import com.blackhole.client.integration.blackhole.BlackholeConnector;
import com.blackhole.client.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张钟
 * @date 2018/3/3
 */
@RestController
@RequestMapping("/dns")
public class PickDNSController {

    @Autowired
    private BlackholeConnector blackholeConnector;

    /**
     * 删除指定用户域的IP地址
     * @return
     */
    @RequestMapping(value = "/delete")
    public String deleteIp(){
        String ip = IPUtils.getClientIp();
        blackholeConnector.deleteAllByIp(ip);
        return "success";
    }

    @RequestMapping(value ="/add")
    public String addDNS(){

        return "success";
    }

    @RequestMapping(value = "/activeProfile")
    public String activateProfile(String profileId){

        return "";
    }

    @RequestMapping(value = "/activateDnsList")
    public String activateDNSList(String dnsList){
        String ip = IPUtils.getClientIp();
        List<DnsMappingVO> dnsMappingVOList = JSONArray.parseArray(dnsList).toJavaList(DnsMappingVO.class);
        blackholeConnector.addByIp(ip,dnsMappingVOList);
        return "success";
    }


}
