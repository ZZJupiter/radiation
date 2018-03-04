package com.blackhole.client.integration.blackhole;

import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.blackhole.client.controller.dns.vo.DnsMappingVO;

import us.codecraft.wifesays.wife.WifeSays;

/**
 * User: cairne
 * Date: 13-5-13
 * Time: 上午7:44
 */
@Service
public class BlackholeConnector {

    @Value("${blackhole.reconnect.times}")
    private Integer             reConnectTimes;

    /**
     * delete_zones_ip_192.168.0.1
     */
    private static final String DELETE_ZONES_IP = "delete_zones_ip_";

    /**
     * add_zones_ip_192.168.0.1:127.0.0.1_*.dianping.com
     */
    private static final String ADD_ZONES_IP    = "add_zones_ip_";

    @Autowired
    private WifeSays            wifeSays;

    private Logger              logger          = Logger.getLogger(getClass());

    public void deleteAllByIp(String ip) {
        if (!isConnected()) {
            if (!connet()) {
                logger.warn(MessageFormat.format("deleteAllByIp error ip:{0}", ip));
                return;
            }
        }
        wifeSays.say(DELETE_ZONES_IP + ip);
        if (isConnected()) {
            logger.info(MessageFormat.format("deleteAllByIp success ip:{0}", ip));
        } else {
            logger.info(MessageFormat.format("deleteAllByIp fail ip:{0}", ip));
        }
    }

    public boolean addByIp(String ip, List<DnsMappingVO> dnsMappingVOList) {
        if (!isConnected()) {
            if (!connet()) {
                logger.warn(MessageFormat.format("addById error ip:{0},line:{1}", ip,
                    JSON.toJSONString(dnsMappingVOList)));
                return false;
            }
        }
        deleteAllByIp(ip);
        for (DnsMappingVO dnsMappingVO : dnsMappingVOList) {
            wifeSays.say(
                ADD_ZONES_IP + ip + ":" + dnsMappingVO.getIp() + "_" + dnsMappingVO.getDomain());
        }
        return true;
    }

    public boolean isConnected() {
        return wifeSays.isConnected();
    }

    public void setConnected(boolean connected) {
        wifeSays.setConnected(connected);
    }

    public boolean connet() {
        for (int i = 0; i < reConnectTimes; i++) {
            try {
                wifeSays.connect();
                Thread.sleep(1000);
                logger.info("black hole connect success");
                return true;
            } catch (Exception e) {
                logger.warn("black hole connect error", e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.warn("black hole connect fail sleep 1 second error", e);
            }
        }
        return false;
    }

}
