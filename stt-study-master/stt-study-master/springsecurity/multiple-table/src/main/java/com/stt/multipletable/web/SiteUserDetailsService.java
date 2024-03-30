package com.stt.multipletable.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.stt.multipletable.doamin.entity.SiteUser;
import com.stt.multipletable.mapper.SiteUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SiteUserDetailsService implements UserDetailsService {

    private final SiteUserMapper siteUserMapper;

    public SiteUserDetailsService(SiteUserMapper siteUserMapper) {
        this.siteUserMapper = siteUserMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        log.info("APP用户登录===================》");
        SiteUser siteUser = siteUserMapper.selectOne(new LambdaQueryWrapper<SiteUser>().eq(SiteUser::getMobile, mobile));
        if(siteUser == null) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }
        return siteUser;
    }
}
