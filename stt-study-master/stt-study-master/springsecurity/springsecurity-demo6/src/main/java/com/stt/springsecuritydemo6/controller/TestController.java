package com.stt.springsecuritydemo6.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test1")
    @PreAuthorize("hasAuthority('sys:menu:list')")
    public String test1() {

        return "sys:menu:list";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAuthority('sys:employee:list')")
    public String test2() {

        return "sys:employee:list";
    }
}
