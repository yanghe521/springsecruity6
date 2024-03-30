package com.stt.springsecuritydemo5.serivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stt.springsecuritydemo5.domain.entity.UmsMenu;
import com.stt.springsecuritydemo5.mapper.UmsMenuMapper;
import com.stt.springsecuritydemo5.serivice.IUmsMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements IUmsMenuService {

}
