package com.blackhole.client.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.blackhole.client.model.DnsMapping;

import java.util.List;

/**
 * <p>
 * dns映射 服务类
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-04
 */
public interface DnsMappingService extends IService<DnsMapping> {

    /**
     * 保存dsn记录
     * @param dnsMapping
     */
    void save(DnsMapping dnsMapping);

    /**
     * 通过配置文件ID分页查询dns映射
     * @param profileId
     * @param currentPage
     * @param pageSize
     * @return
     */
    Page<DnsMapping> queryByProfile(Long profileId, int currentPage, int pageSize);

    /**
     * 根据配置查询所有的dns映射
     * @param profileId
     * @return
     */
    List<DnsMapping> queryByProfile(Long profileId);

}
