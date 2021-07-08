package com.haowq.mapper;

import com.haowq.anno.DataSource;
import com.haowq.enm.DataSourceType;
import com.haowq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    @DataSource(value = DataSourceType.USER)
    int insert(User record);

    int insertSelective(User record);
}