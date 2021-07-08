package com.haowq.config;

import com.haowq.enm.DataSourceType;
import com.haowq.mult.DynamicDataSource;
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
    @ConfigurationProperties("spring.datasource.remote")
    public DataSource remoteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.local")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource remoteDataSource, DataSource localDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.REMOTE.name(), remoteDataSource);
        targetDataSources.put(DataSourceType.LOCAL.name(), localDataSource);
        return new DynamicDataSource(remoteDataSource, targetDataSources);
    }
}
