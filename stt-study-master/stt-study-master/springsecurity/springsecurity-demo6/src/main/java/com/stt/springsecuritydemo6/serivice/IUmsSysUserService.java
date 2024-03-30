package com.stt.springsecuritydemo6.serivice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stt.springsecuritydemo6.domain.dto.LoginParams;
import com.stt.springsecuritydemo6.domain.entity.UmsSysUser;

public interface IUmsSysUserService extends IService<UmsSysUser> {
    String login(LoginParams loginParams);

}
