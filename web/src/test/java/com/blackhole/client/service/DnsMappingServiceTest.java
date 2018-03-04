package com.blackhole.client.service;

import java.util.Date;

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
public class DnsMappingServiceTest {

    @Autowired
    private DnsMappingService dnsMappingService;

    @Test
    public void test_insert() {
        DnsMapping dnsMapping = new DnsMapping();
        dnsMapping.setProfileId(1l);
        dnsMapping.setIp("192.168.1.2");
        dnsMapping.setDomain("a.hanma.com");
        dnsMapping.setMemo("测试地址");
        dnsMapping.setCreated(new Date());
        dnsMappingService.save(dnsMapping);
    }
}
