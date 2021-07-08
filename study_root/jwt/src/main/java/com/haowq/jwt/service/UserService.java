package com.haowq.jwt.service;

import com.haowq.jwt.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: haowq
 * @Date: 2021/6/2 17:32
 * @Description:
 */
@Service
public class UserService {
    public User findUserById(String userId) {
        return new User("123456","haowq","123456");
    }
}
