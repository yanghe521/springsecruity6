package com.stt.multipletable.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.stt.multipletable.doamin.entity.SysUser;
import com.stt.multipletable.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 后台管理系统用户登陆实现接口
 */
@Slf4j
@Service
public class SysUserDetailsService implements UserDetailsService {

    private final SysUserMapper sysUserMapper;

    public SysUserDetailsService(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    /**
     * 此方法从数据库中查询用户
     * 返回一个 UserDetails
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("后台系统用户登录=============》");
        // 根据用户名查询用户
        SysUser sysUser = sysUserMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username));
        // 有权限的话，需要查询该用户对应的权限
        if(sysUser == null) {
            throw new UsernameNotFoundException("用户或密码不正确");
        }
        return sysUser;
    }
}
