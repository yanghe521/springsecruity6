package com.stt.multipletable.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stt.multipletable.doamin.dto.LoginParam;
import com.stt.multipletable.doamin.entity.SiteUser;

public interface ISiteUserService extends IService<SiteUser> {
    String siteLogin(LoginParam loginParam);
}
