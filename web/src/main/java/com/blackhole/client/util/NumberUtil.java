package com.blackhole.client.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author 张钟
 * @date 2017/12/21
 */
public class NumberUtil {

    public static int getNumberFromString(String text) {
        StringBuilder sb = new StringBuilder();
        for (String sss : text.replaceAll("[^0-9]", ",").split(",")) {
            if (sss.length() > 0) {
                sb.append(sss);
            }
        }
        if(StringUtils.isBlank(sb.toString())){
            return 0;
        }
        return Integer.valueOf(sb.toString());
    }
}
