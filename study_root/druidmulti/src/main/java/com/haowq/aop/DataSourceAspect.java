package com.haowq.aop;

import com.haowq.anno.DataSource;
import com.haowq.mult.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:43
 * @Description: 通过拦截 @DataSource 注解，在其执行之前处理设置当前执行SQL的数据源的信息，
 * CONTEXT_HOLDER.set(dataSourceType)这里的数据源信息从我们设置的注解上面获取信息，
 * 如果没有设置就是用默认的数据源的信息。
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.haowq.anno.DataSource)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            //通过注解值设置数据源
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.value().name());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

}
