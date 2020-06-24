package com.Beaver.MainService.config.auth.dto;

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
    private int id;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey,
                           int id,
                           String name,
                           String email,
                           String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {
        if("kakao".equals(registrationId)) {
            ofKakao(userNameAttributeName, attributes);
        }
        else if("naver".equals(registrationId)) {

        }
        else if("google".equals(registrationId)) {

        }


        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofKakao(String userNameAttributeName,
                                           Map<String, Object> attributes) {

        Map<String, Object> properties = ( Map<String, Object> )attributes.get("properties");
        Map<String, Object> kakaoAccount = ( Map<String, Object> )attributes.get("kakao_account");


        return OAuthAttributes.builder()
                .id((Integer)attributes.get("id"))
                .name((String) properties.get("nickname"))
                //.name((String)attributes.get("name"))
                //.name((String) attributes.get("name"))
                //.email((String) attributes.get("email"))
                .picture((String) properties.get("profile_image"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public static OAuthAttributes ofGoogle(String userNameAttributeName,
                                           Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
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
