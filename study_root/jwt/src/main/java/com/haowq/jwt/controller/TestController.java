package com.haowq.jwt.controller;

import com.haowq.jwt.anno.CheckToken;
import com.haowq.jwt.anno.LoginToken;
import com.haowq.jwt.domain.User;
import com.haowq.jwt.util.JWTUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: haowq
 * @Date: 2021/6/2 18:56
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/login")
    @LoginToken
    public String login(){
        System.out.println("adfsasdfa");

        //登录成功后要返回token
        return JWTUtil.createJWT(1000000,new User("123456","haowq","123456"));

    }

    @CheckToken
    @GetMapping("/info")
    public String getUserInfo(){
        return "您已通过验证";
    }

    @GetMapping("/message")
    public String getUserMessage(){
        return "您已通过验证message";
    }
}

