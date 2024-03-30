package com.stt.springsecuritydemo9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("to_login")
    public String login() {
        return "login";
    }
}
