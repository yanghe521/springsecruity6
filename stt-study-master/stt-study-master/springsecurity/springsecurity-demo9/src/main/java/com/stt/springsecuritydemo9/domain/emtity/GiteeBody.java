package com.stt.springsecuritydemo9.domain.emtity;

import lombok.Data;

@Data
public class GiteeBody {

    private String accessToken;
    private String tokenType;
    private String refreshToken;
}
