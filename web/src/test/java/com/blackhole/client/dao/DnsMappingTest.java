package com.blackhole.client.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blackhole.client.model.DnsMapping;

/**
 * @author 张钟
 * @date 2018/3/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DnsMappingTest {

    @Autowired
    private DnsMappingMapper dnsMappingMapper;

    @Test
    public void test_insert() {
        DnsMapping dnsMapping = new DnsMapping();
        dnsMapping.setProfileId(1l);
        dnsMapping.setIp("192.168.1.1");
        dnsMapping.setDomain("a.hanma.com");
        dnsMapping.setMemo("测试地址");
        dnsMapping.setCreated(new Date());
        int insertResult = dnsMappingMapper.insert(dnsMapping);
        System.out.println(insertResult);
    }

    @Test
    public void test() {
        List<DnsMapping> dnsMappingList = dnsMappingMapper.selectByProfile(1l);
        System.out.println(dnsMappingList);
    }
}
