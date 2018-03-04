package com.blackhole.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.blackhole.client.dao.DnsMappingMapper;
import com.blackhole.client.model.DnsMapping;
import com.blackhole.client.service.DnsMappingService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * dns映射 服务实现类
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-04
 */
@Service
public class DnsMappingServiceImpl extends ServiceImpl<DnsMappingMapper, DnsMapping>
                                   implements DnsMappingService {

    @Autowired
    private DnsMappingMapper dnsMappingMapper;

    /**
     * 保存dns记录
     * @param dnsMapping
     */
    @Override
    public void save(DnsMapping dnsMapping) {
        Date currentDate = new Date();
        if(dnsMapping.getId()==null){
            dnsMapping.setCreated(currentDate);
            dnsMapping.setUpdated(currentDate);
            insert(dnsMapping);
        }else{
            dnsMapping.setUpdated(currentDate);
            updateById(dnsMapping);
        }
    }

    /**
     * 根据配置ID查询dns列表
     * @param profileId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<DnsMapping> queryByProfile(Long profileId, int currentPage, int pageSize) {
        Page<DnsMapping> page = new Page<>(currentPage, pageSize);
        page.setRecords(dnsMappingMapper.selectByProfile(profileId));
        return page;
    }

    /**
     * 根据配置查询所有的dns映射
     * @param profileId
     * @return
     */
    @Override
    public List<DnsMapping> queryByProfile(Long profileId) {
        return dnsMappingMapper.selectByProfile(profileId);
    }
}
