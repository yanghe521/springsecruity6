package com.stt.multipletable.doamin.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@TableName("ums_site_user")
public class SiteUser implements Serializable, UserDetails {

    private Long id;
    private String username;
    private String nickname;
    private String openid;
    private String email;
    private String mobile;
    private Integer sex;
    private String avatar;
    @JsonIgnore
    private String password;
    private Integer status;
    private Long updater;
    private String remark;
    @TableLogic
    private Integer deleted;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    /**
     * 权限。现在并没有查询权限
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
