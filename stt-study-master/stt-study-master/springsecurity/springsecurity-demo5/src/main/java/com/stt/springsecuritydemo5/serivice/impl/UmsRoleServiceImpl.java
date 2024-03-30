package com.stt.springsecuritydemo5.serivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.springsecuritydemo5.domain.entity.UmsRole;
import com.stt.springsecuritydemo5.mapper.UmsRoleMapper;
import com.stt.springsecuritydemo5.serivice.IUmsRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleMapper, UmsRole> implements IUmsRoleService {

}
