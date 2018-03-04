package com.blackhole.client.convert;

import com.blackhole.client.controller.dns.request.SaveDnsForm;
import com.blackhole.client.controller.dns.vo.DnsMappingVO;
import com.blackhole.client.model.DnsMapping;
import com.blackhole.client.util.bean.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张钟
 * @date 2018/3/4
 */
public class DnsConvert {

    public static DnsMapping convert(SaveDnsForm form){
        if(form == null){
            return null;
        }
        DnsMapping dnsMapping = new DnsMapping();
        BeanUtils.copyProperties(form,dnsMapping);
        return dnsMapping;
    }

    public static DnsMappingVO convert(DnsMapping dnsMapping){
        DnsMappingVO dnsMappingVO = new DnsMappingVO();
        dnsMappingVO.setDomain(dnsMapping.getDomain());
        dnsMappingVO.setIp(dnsMapping.getIp());
        dnsMappingVO.setMemo(dnsMapping.getMemo());
        return dnsMappingVO;
    }

    public static List<DnsMappingVO> convert(List<DnsMapping> dnsMappingList){
        List<DnsMappingVO> dnsMappingVOList = new ArrayList<>();
        for(DnsMapping dnsMapping : dnsMappingList){
            dnsMappingVOList.add(convert(dnsMapping));
        }
        return dnsMappingVOList;
    }
}
