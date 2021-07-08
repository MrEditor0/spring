package com.haowq.config;

import com.haowq.datasource.DynamicDataSource;
import com.haowq.enm.DataSourceType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:37
 * @Description: 注入数据源
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.user")
    public DataSource userDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.order")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource userDataSource, DataSource orderDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.USER.name(), userDataSource);
        targetDataSources.put(DataSourceType.ORDER.name(), orderDataSource);
        return new DynamicDataSource(userDataSource, targetDataSources);
    }
}
