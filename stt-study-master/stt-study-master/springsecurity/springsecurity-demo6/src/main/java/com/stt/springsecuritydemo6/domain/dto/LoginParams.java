package com.stt.springsecuritydemo6.domain.dto;

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
