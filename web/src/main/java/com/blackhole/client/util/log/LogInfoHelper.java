package com.blackhole.client.util.log;

import java.util.UUID;

/**
 * @author 张钟
 * @date 2017/11/9
 */
public class LogInfoHelper {

    private LogInfoHelper() {// 构造方法私有化

    }

    public static LogInfoHelper getInstance() {
        LogInfoHelper logInfoHelper = threadLocal.get();//当我们从当前线程中的ThreadLocal中拿不到对象的时候我们就创建新的对象
        if (logInfoHelper == null) {
            logInfoHelper = new LogInfoHelper();
            logInfoHelper.timeKey = UUID.randomUUID().toString().replace("-", "");
            threadLocal.set(logInfoHelper);
        }
        return logInfoHelper;
    }

    public static void destroy(){
        threadLocal.remove();
    }

    //在对象内部创建一个ThreadLocal，这样当每个线程来创建对象的时候，创建的都是这个线程自己内部的对象
    private static ThreadLocal<LogInfoHelper> threadLocal = new ThreadLocal<LogInfoHelper>();

    private String                            timeKey;

    public String getTimeKey() {
        return timeKey;
    }
}
