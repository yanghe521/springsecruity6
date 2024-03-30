package com.stt.springsecuritydemo8.domain.emtity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("persistent_logins")
public class PersistentLogins {

    private String series;
    private String username;
    private String token;
    private Date lastUsed;

}
