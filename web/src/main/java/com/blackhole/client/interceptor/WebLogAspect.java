package com.blackhole.client.interceptor;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.blackhole.client.util.IPUtils;
import com.blackhole.client.util.log.LogInfoHelper;
import com.blackhole.client.util.log.LogUtil;

/**
 * @author 张钟
 * @date 2017/11/9
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.blackhole.client.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        LogInfoHelper.getInstance();

        String url = request.getRequestURL().toString();
        String param = JSON.toJSONString(request.getParameterMap());
        String ip = IPUtils.getClientIp();
        HttpSession session = request.getSession();
        //        String nickName = String.valueOf(session.getAttribute(BaseController.NICKNAME));
        //        String domain = String.valueOf(session.getAttribute(BaseController.DOMAIN));

        LogUtil.info(logger, MessageFormat
            .format("REQUEST=>ip:{0} url:{1} operator:{2},{3} param:{4}", ip, url, "", "", param));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        // LogUtil.info(logger, "RESPONSE=>" + JSON.toJSONString(ret));
        LogInfoHelper.destroy();
    }

    @AfterThrowing(value = "webLog()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        LogUtil.error(logger, e, "请求异常");
        LogInfoHelper.destroy();
    }

}
