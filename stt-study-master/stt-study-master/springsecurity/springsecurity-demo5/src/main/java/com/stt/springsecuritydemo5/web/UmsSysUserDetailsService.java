package com.stt.springsecuritydemo5.web;

import com.stt.springsecuritydemo5.domain.entity.UmsSysUser;
import com.stt.springsecuritydemo5.mapper.UmsSysUserMapper;
import com.stt.springsecuritydemo5.domain.entity.UmsMenu;
import com.stt.springsecuritydemo5.domain.entity.UmsRole;
import com.stt.springsecuritydemo5.mapper.UmsMenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class UmsSysUserDetailsService implements UserDetailsService {

    private final UmsSysUserMapper sysUserMapper;
    private final UmsMenuMapper menuMapper;

    public UmsSysUserDetailsService(UmsSysUserMapper sysUserMapper,UmsMenuMapper menuMapper) {
        this.sysUserMapper = sysUserMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 做用户信息查询，不要多次访问数据库，尽量一次查出需要的数据，多表查询不要超过3张表
        // 1、查询用户的角色信息
        UmsSysUser umsSysUser = sysUserMapper.selectUserByUsername(username);
        log.info("没有权限===>{}",umsSysUser);
        // 2、查询用户的权限信息
        if(umsSysUser != null) {
            Set<UmsRole> roleSet =  umsSysUser.getRoleSet();
            // 存储角色id，进行批量查询，不要在for循环中查询数据库
            Set<Long> roleIds = new HashSet<>(roleSet.size());
            // 获取用户的权限列表
            Set<String> perms = umsSysUser.getPerms();
            for (UmsRole umsRole : roleSet) {
                roleIds.add(umsRole.getRoleId());
            }
            // 权限查询
            Set<UmsMenu> menus = menuMapper.selectMenuByRoleId(roleIds);
            for (UmsMenu menu : menus) {
                String perm = menu.getPerms();
                // 添加用户权限到set中
                perms.add(perm);
            }
            log.info("有权限====》{}",umsSysUser);
        }
        return umsSysUser;
    }
}

















