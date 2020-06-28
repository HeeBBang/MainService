package com.Beaver.MainService.config.auth.dto;

import com.Beaver.MainService.config.auth.SocialType;
import com.Beaver.MainService.domain.user.Role;
import com.Beaver.MainService.domain.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String id;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;
    private SocialType socialType;

    private String kakaoId;
    private String kakaoNickName;

    private String naverId;
    private String naverName;

    private String googleId;
    private String googleName;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           String id,
                           String name,
                           String email,
                           String picture,
                           SocialType socialType,
                           String kakaoId,
                           String kakaoNickName,
                           String naverId,
                           String naverName,
                           String googleId,
                           String googleName ) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.socialType = socialType;

        this.kakaoId = kakaoId;
        this.kakaoNickName = kakaoNickName;

        this.naverId = naverId;
        this.naverName = naverName;

        this.googleId = googleId;
        this.googleName = googleName;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if("kakao".equals(registrationId)) {
            return ofKakao(userNameAttributeName, attributes);
        }
        else if("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        }
        else if("google".equals(registrationId)) {
            return ofGoogle(userNameAttributeName, attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes) {

        Map<String, Object> properties = ( Map<String, Object> )attributes.get("properties");
        Map<String, Object> kakaoAccount = ( Map<String, Object> )attributes.get("kakao_account");

        return OAuthAttributes.builder()
                .kakaoId(attributes.get("id").toString())
                .kakaoNickName(properties.get("nickname").toString())
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .socialType(SocialType.KAKAO)
                .build();
    }

    public static OAuthAttributes ofNaver(String userNameAttributeName,
                                          Map<String, Object> attributes) {

        return OAuthAttributes.builder()
                .naverId(attributes.get(userNameAttributeName).toString())
                .naverName(attributes.get("name").toString())
                .socialType(SocialType.NAVER)
                .build();
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .googleId(attributes.get(userNameAttributeName).toString())
                .googleName(attributes.get("name").toString())
                .email(attributes.get("email").toString())
                .picture(attributes.get("picture").toString())
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .socialType(SocialType.GOOGLE)
                .build();
    }


    public User toKakaoEntity() {
        return User.builder()
                .kakaoId(kakaoId)
                .kakaoNickName(kakaoNickName)
                .role(Role.GUEST)
                .build();
    }

    public User toGoogleEntity() {
        return User.builder()
                .googleId(googleId)
                .googleName(name)
                .role(Role.GUEST)
                .build();
    }


    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
