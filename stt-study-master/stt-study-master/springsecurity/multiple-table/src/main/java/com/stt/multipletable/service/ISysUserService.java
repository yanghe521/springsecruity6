package com.stt.multipletable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stt.multipletable.doamin.dto.LoginParam;
import com.stt.multipletable.doamin.entity.SysUser;

public interface ISysUserService extends IService<SysUser> {
    String sysLogin(LoginParam loginParam);

}
