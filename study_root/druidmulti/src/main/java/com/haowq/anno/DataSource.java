package com.haowq.anno;

import com.haowq.enm.DataSourceType;

import java.lang.annotation.*;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:42
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    DataSourceType value() default DataSourceType.REMOTE;
}
