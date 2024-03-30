package com.stt.springsecuritydemo8.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stt.springsecuritydemo8.domain.emtity.PersistentLogins;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersistentLoginsMapper extends BaseMapper<PersistentLogins> {

}
