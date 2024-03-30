package com.stt.springsecuritydemo3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PageController {

    // 跳转到登录页面
    @GetMapping("to_login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
