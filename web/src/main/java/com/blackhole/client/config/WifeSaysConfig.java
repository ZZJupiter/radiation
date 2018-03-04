package com.blackhole.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.wifesays.wife.WifeSays;

/**
 * @author 张钟
 * @date 2018/3/3
 */
@Configuration
public class WifeSaysConfig {

    @Value("${blackhole.address}")
    private String blackHoleAddress;

    @Bean
    public WifeSays getWifeSays(){
        WifeSays.DEFAULT_ADDRESS =blackHoleAddress;
        WifeSays wifeSays = new WifeSays();
        return wifeSays;
    }
}
