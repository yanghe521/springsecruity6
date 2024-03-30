package com.stt.multipletable.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.multipletable.doamin.dto.LoginParam;
import com.stt.multipletable.doamin.entity.SysUser;
import com.stt.multipletable.mapper.SysUserMapper;
import com.stt.multipletable.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * 系统用户的登陆，
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    @Qualifier("sysUserAuthenticationManager")
    private AuthenticationManager authenticationManager;

    /**
     * 登陆是SpringSecurity实现的，我们就是去告诉SpringSecurity现在要登陆
     * SpringSecirity登陆是通过 AuthticationManager 实现的
     * 将AuthticationManager引入到service中，调用他的认证方法就可以了
     * @param loginParam
     * @return
     */
    @Override
    public String sysLogin(LoginParam loginParam) {
        // 通过authenticationManager 的认证方法实现登录，该方法需要传入 Authentication 对象 就是一个认证对象
        // Authenticationl里边存储的就是用户的认证信息，权限，用户名，密码的等信息，其实就是loadUserByUsername方法返回的UserDetails
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 获取用户信息
        SysUser sysUser = (SysUser) authenticate.getPrincipal();
        log.info("sysUser==========》{}",sysUser);
        // 返回的是token
        return sysUser.getUsername();
    }
}
