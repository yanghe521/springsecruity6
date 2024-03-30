package com.stt.multipletable.doamin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginParam implements Serializable {

    // 后台管理系统登陆
    private String username;
    // APP用户登陆
    private String mobile;
    // 密码
    private String password;

}
