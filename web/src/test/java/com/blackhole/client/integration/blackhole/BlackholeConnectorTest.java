package com.blackhole.client.integration.blackhole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 张钟
 * @date 2018/3/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlackholeConnectorTest {

    @Autowired
    private BlackholeConnector blackholeConnector;

    @Test
    public void deleteAllByIp(){
        blackholeConnector.deleteAllByIp("192.168.2.12");
    }
}
