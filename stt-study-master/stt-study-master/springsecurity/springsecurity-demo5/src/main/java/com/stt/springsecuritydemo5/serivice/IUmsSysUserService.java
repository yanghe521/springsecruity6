package com.stt.springsecuritydemo5.serivice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stt.springsecuritydemo5.domain.dto.LoginParams;
import com.stt.springsecuritydemo5.domain.entity.UmsSysUser;

public interface IUmsSysUserService extends IService<UmsSysUser> {
    String login(LoginParams loginParams);

}
