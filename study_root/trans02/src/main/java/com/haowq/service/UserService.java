package com.haowq.service;

import com.haowq.anno.DataSource;
import com.haowq.enm.DataSourceType;
import com.haowq.entity.Order;
import com.haowq.entity.User;
import com.haowq.mapper.OrderMapper;
import com.haowq.mapper.UserMapper;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: haowq
 * @Date: 2021/7/7 13:03
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Transactional(rollbackFor = {Exception.class})
    //@DataSource(value = DataSourceType.USER)
    public int add(int id){
        User user = new User();

        user.setPass("123");
        user.setName("haowq1");
        user.setId(id);
        userMapper.insert(user);

        Order order = new Order();

        //for(int i =0;i<10;i++){
            order.setId(id+1);
            order.setOrderName("werwe");
            orderMapper.insert(order);
        //}

        //int num = 10/0;
        return 1;
    }
}
