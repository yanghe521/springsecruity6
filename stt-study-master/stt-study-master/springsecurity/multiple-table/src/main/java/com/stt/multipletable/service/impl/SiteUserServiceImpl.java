package com.stt.multipletable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.multipletable.doamin.dto.LoginParam;
import com.stt.multipletable.doamin.entity.SiteUser;
import com.stt.multipletable.mapper.SiteUserMapper;
import com.stt.multipletable.service.ISiteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SiteUserServiceImpl extends ServiceImpl<SiteUserMapper, SiteUser> implements ISiteUserService {

    /**
     * 将AuthenticationManager注入
     */
    @Autowired
    @Qualifier("siteUserAuthenticationManager")
    private AuthenticationManager authenticationManager;

    @Override
    public String siteLogin(LoginParam loginParam) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginParam.getMobile(), loginParam.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 强转为用户类型
        SiteUser siteUser = (SiteUser) authenticate.getPrincipal();
        log.info("siteUser===========>{}",siteUser);
        return siteUser.getUsername();
    }
}
