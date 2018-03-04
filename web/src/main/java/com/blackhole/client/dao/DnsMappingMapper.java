package com.blackhole.client.dao;

import com.blackhole.client.model.DnsMapping;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * dns映射 Mapper 接口
 * </p>
 *
 * @author 简一带你飞
 * @since 2018-03-04
 */
public interface DnsMappingMapper extends BaseMapper<DnsMapping> {

    /**
     * 根据配置ID 查询 dns映射
     * @param profileId
     * @return
     */
    List<DnsMapping> selectByProfile(@Param("profileId") Long profileId);

    /**
     * 通过配置文件删除配置
     * @param profileId
     */
    void deleteByProfileId(@Param("profileId") Long profileId);

}
