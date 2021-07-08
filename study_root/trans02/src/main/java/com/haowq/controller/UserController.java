package com.haowq.controller;

import com.haowq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: haowq
 * @Date: 2021/7/7 13:06
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String add(@RequestParam  int id){
        int add = userService.add(id);
        if(add >0){
            return "success";
        }else{
            return "failed";
        }
    }

}
