package com.stt.multipletable.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stt.multipletable.doamin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
