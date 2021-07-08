package com.haowq.controller;

import com.haowq.anno.DataSource;
import com.haowq.enm.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:57
 * @Description:
 */
@RestController
@RequestMapping("/multi")
public class MultDataSourceController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/local")
    @DataSource(DataSourceType.LOCAL)
    public List<Map<String, Object>> local() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from emp");
        return maps;
    }

    @GetMapping("/remote")
    @DataSource(DataSourceType.REMOTE)
    public List<Map<String, Object>> remote() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from emp");
        return maps;
    }
}
