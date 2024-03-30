package com.stt.springsecuritydemo5.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stt.springsecuritydemo5.domain.entity.UmsSysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmsSysUserMapper extends BaseMapper<UmsSysUser> {
    UmsSysUser selectUserByUsername(@Param("username") String username);
}
