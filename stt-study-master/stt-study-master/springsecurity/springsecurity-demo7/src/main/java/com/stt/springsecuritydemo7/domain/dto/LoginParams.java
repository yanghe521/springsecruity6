package com.stt.springsecuritydemo7.domain.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 登录参数
 */
@Data
public class LoginParams implements Serializable {

    private String username;
    private String password;

}
