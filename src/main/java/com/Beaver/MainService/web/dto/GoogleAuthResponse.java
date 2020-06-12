package com.Beaver.MainService.web.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoogleAuthResponse {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private long expiresIn;
    private String scope;
}
