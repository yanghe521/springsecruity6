package com.stt.springsecuritydemo6.serivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.springsecuritydemo6.domain.entity.UmsMenu;
import com.stt.springsecuritydemo6.domain.entity.UmsRole;
import com.stt.springsecuritydemo6.mapper.UmsMenuMapper;
import com.stt.springsecuritydemo6.mapper.UmsRoleMapper;
import com.stt.springsecuritydemo6.serivice.IUmsMenuService;
import com.stt.springsecuritydemo6.serivice.IUmsRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {

}
