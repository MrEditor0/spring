package com.haowq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: haowq
 * @Date: 2021/7/6 14:02
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
