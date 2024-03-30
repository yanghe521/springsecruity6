package com.stt.springsecuritydemo6.controller;

import com.stt.springsecuritydemo6.domain.dto.LoginParams;
import com.stt.springsecuritydemo6.serivice.IUmsSysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final IUmsSysUserService sysUserService;

    public AuthController(IUmsSysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 登录方法：返回一个令牌
     * 用户再次访问时，在请求头 header：携带token
     */
    @PostMapping("login")
    public Map<String,Object> login(@RequestBody LoginParams loginParams) {
        String token = sysUserService.login(loginParams);
        HashMap<String, Object> result = new HashMap<>();
        result.put("code",200);
        result.put("token",token);
        result.put("msg","登陆成功");
        return result;
    }
}
