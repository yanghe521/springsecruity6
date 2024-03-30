package com.stt.springsecuritydemo8.token;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.stt.springsecuritydemo8.domain.emtity.PersistentLogins;
import com.stt.springsecuritydemo8.mapper.PersistentLoginsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class DaoCaoPersistentTokenRepositoryImpl implements PersistentTokenRepository {

    private final PersistentLoginsMapper persistentLoginsMapper;

    public DaoCaoPersistentTokenRepositoryImpl(PersistentLoginsMapper persistentLoginsMapper) {
        this.persistentLoginsMapper = persistentLoginsMapper;
    }

    /**
     * 创建token
     * @param token
     */
    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        log.info("createNewToken=====>");
        PersistentLogins persistentLogins = new PersistentLogins();
        persistentLogins.setSeries(token.getSeries());
        persistentLogins.setUsername(token.getUsername());
        persistentLogins.setToken(token.getTokenValue());
        persistentLogins.setLastUsed(token.getDate());
        // 存储到数据库中
        persistentLoginsMapper.insert(persistentLogins);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        LambdaUpdateWrapper<PersistentLogins> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(PersistentLogins::getToken,tokenValue).set(PersistentLogins::getLastUsed,lastUsed)
                .eq(PersistentLogins::getSeries,series);
        // 调用修改方法
        persistentLoginsMapper.update(null,updateWrapper);
    }

    /**
     * 获取token
     * @param seriesId
     * @return
     */
    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        LambdaQueryWrapper<PersistentLogins> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PersistentLogins::getSeries,seriesId);
        // 调用查询方法
        PersistentLogins result = persistentLoginsMapper.selectOne(queryWrapper);

        PersistentRememberMeToken retrunResult = new PersistentRememberMeToken(
                result.getUsername(),result.getSeries(),result.getToken(),result.getLastUsed()
        );
        return retrunResult;
    }

    @Override
    public void removeUserTokens(String username) {
        LambdaUpdateWrapper<PersistentLogins> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(PersistentLogins::getUsername,username);
        persistentLoginsMapper.delete(updateWrapper);
    }
}
