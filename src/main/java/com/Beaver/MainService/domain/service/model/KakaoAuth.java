package com.Beaver.MainService.domain.service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoAuth {
    /*
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private Long expiresIn;
    private String scope;
*/
    private String access_token;
    private String token_type;
    private String refresh_token;
    private long expires_in;
    private String scope;
}
