package com.haowq;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 13:56
 * @Description:
 */
@SpringBootTest
public class DataApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws Exception {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getMaxActive());
        System.out.println(druidDataSource.getInitialSize());
        System.out.println(druidDataSource.getFilterClassNames());

        connection.close();

    }
}
