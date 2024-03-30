package com.stt.springsecuritydemo6.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stt.springsecuritydemo6.domain.entity.UmsSysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UmsSysUserMapper extends BaseMapper<UmsSysUser> {
}
