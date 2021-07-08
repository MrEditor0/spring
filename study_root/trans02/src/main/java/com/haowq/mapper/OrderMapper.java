package com.haowq.mapper;

import com.haowq.anno.DataSource;
import com.haowq.enm.DataSourceType;
import com.haowq.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @DataSource(value = DataSourceType.ORDER)
    int insert(Order order);
}