package com.stt.springsecuritydemo6.serivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.springsecuritydemo6.domain.dto.LoginParams;
import com.stt.springsecuritydemo6.domain.entity.UmsRole;
import com.stt.springsecuritydemo6.domain.entity.UmsSysUser;
import com.stt.springsecuritydemo6.mapper.UmsRoleMapper;
import com.stt.springsecuritydemo6.mapper.UmsSysUserMapper;
import com.stt.springsecuritydemo6.serivice.IUmsRoleService;
import com.stt.springsecuritydemo6.serivice.IUmsSysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {

}
