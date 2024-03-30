package com.stt.springsecuritydemo7.web.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.stt.springsecuritydemo7.domain.entity.UmsMenu;
import com.stt.springsecuritydemo7.mapper.UmsMenuMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * 判断请求路径是否有权限访问
 */
@Component
@Slf4j
public class SttAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    private final UmsMenuMapper menuMapper;

    public SttAuthorizationManager(UmsMenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        // 获取请求路径,获取HttpServletRequest
        HttpServletRequest request = requestAuthorizationContext.getRequest();
        String uri = request.getRequestURI();
        String url = request.getRequestURL().toString();
        log.info("uri=============>{}",uri);
        log.info("url=============>{}",url);
        // 有些请求不需要认证
        if("/auth/login".equals(uri) || "/logout".equals(uri) || "/error".equals(uri)) {
            return new AuthorizationDecision(true);
        }
        // 根据uri获取路径的权限
        UmsMenu umsMenu = menuMapper.selectOne(new LambdaQueryWrapper<UmsMenu>().eq(UmsMenu::getPath, uri.replaceFirst("/","")));
        if(umsMenu == null) {
            return new AuthorizationDecision(false);
        }
        // 获取路径访问权限
        String menuPerm = umsMenu.getPerms();
        log.info("路径权限=============>{}",menuPerm);
        if(menuPerm == null || menuPerm.trim().equals("")) {
            return new AuthorizationDecision(true);
        }

        // 与用户权限集合做判断
        Collection<? extends GrantedAuthority> authorities = authentication.get().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            String userPerm = authority.getAuthority();
            log.info("用户权限=============>{}",userPerm);
            if(userPerm.equals(menuPerm)) {
                return new AuthorizationDecision(true);
            }
        }
        return new AuthorizationDecision(false);
    }
}
