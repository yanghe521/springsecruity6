package com.stt.multipletable.controller;

import com.stt.multipletable.doamin.dto.LoginParam;
import com.stt.multipletable.service.ISiteUserService;
import com.stt.multipletable.service.ISysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ISysUserService sysUserService;
    private final ISiteUserService siteUserService;

    public AuthController(ISysUserService sysUserService, ISiteUserService siteUserService) {
        this.sysUserService = sysUserService;
        this.siteUserService = siteUserService;
    }

    /**
     * 后端管理系统登陆
     * 返回值：token
     */
    @PostMapping("sys_login")
    public String sysLogin(@RequestBody LoginParam loginParam) {

        return "后台用户登陆======》" +sysUserService.sysLogin(loginParam);
    }

    @PostMapping("site_login")
    public String siteLogin(@RequestBody LoginParam loginParam) {

        return "APP用户登陆======》" + siteUserService.siteLogin(loginParam);
    }

}
