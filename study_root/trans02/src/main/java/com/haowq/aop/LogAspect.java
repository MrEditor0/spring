package com.haowq.aop;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: haowq
 * @Date: 2021/7/7 15:06
 * @Description:
 */
@Service
@Aspect
@Order(2)
public class LogAspect {
    public static final Logger logger= LoggerFactory.getLogger("LogAspect.class");
    @Pointcut("execution(* com.haowq.service.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("========================================== Start ==========================================");
        //打印请求参数相关日志
        // 打印请求 url
        logger.info("url:{}", request.getRequestURI().toString());
        // 打印 Http method
        logger.info("HTTP Method:{}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method:{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP :{}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args:{}", new Gson().toJson(joinPoint.getArgs()));
    }

    @After("pointcut()")
    public void doAfter() {
        logger.info("========================================== end ==========================================");
    }

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("test rollback");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            //打印出参
            logger.info("Respo" +
                    "" +
                    "nse Args : {}", new Gson().toJson(result));
            // 执行耗时
            logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        }catch (Exception e){
            //打印出参
            logger.info("Respo" +
                    "" +
                    "nse Args : {}", new Gson().toJson(result));
            // 执行耗时
            logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
            throw new RuntimeException();
        }
        // result = proceedingJoinPoint.proceed();
        return result;
    }
}
