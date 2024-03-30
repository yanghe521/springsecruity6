package com.stt.springsecuritydemo5.serivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.springsecuritydemo5.domain.dto.LoginParams;
import com.stt.springsecuritydemo5.domain.entity.UmsSysUser;
import com.stt.springsecuritydemo5.mapper.UmsSysUserMapper;
import com.stt.springsecuritydemo5.serivice.IUmsSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UmsSysUserServiceImpl extends ServiceImpl<UmsSysUserMapper, UmsSysUser> implements IUmsSysUserService {

    private final AuthenticationManager authenticationManager;

    public UmsSysUserServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * 间接调用 loadUserByUsername方法
     * @param loginParams
     * @return
     */
    @Override
    public String login(LoginParams loginParams) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginParams.getUsername(), loginParams.getPassword());
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(authenticationToken);
        }catch (AuthenticationException e) {
            log.info("用户名或密码错误！");
            return "";
        }
        // 就获取用户信息，返回token
        UmsSysUser umsSysUser = (UmsSysUser) authentication.getPrincipal();
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }
}
