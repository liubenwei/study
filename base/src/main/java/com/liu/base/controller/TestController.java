package com.liu.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu
 * @Date 2020/9/28 17:19
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "测试";
    }
}
