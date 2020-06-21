package com.Beaver.MainService.resolver;

import com.Beaver.MainService.annotation.SocialUser;
import com.Beaver.MainService.config.auth.SocialType;
import com.Beaver.MainService.domain.IntegratedUser.IntegratedUser;
import com.Beaver.MainService.domain.IntegratedUser.IntegratedUserRepository;
import org.springframework.core.MethodParameter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import static com.Beaver.MainService.config.auth.SocialType.FACEBOOK;
import static com.Beaver.MainService.config.auth.SocialType.GOOGLE;
import static com.Beaver.MainService.config.auth.SocialType.KAKAO;
import static com.Beaver.MainService.config.auth.SocialType.NAVER;


@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private IntegratedUserRepository integratedUserRepository;

    public UserArgumentResolver(IntegratedUserRepository integratedUserRepository) {
        this.integratedUserRepository = integratedUserRepository;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(SocialUser.class) != null && parameter.getParameterType().equals(IntegratedUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        IntegratedUser integratedUser = (IntegratedUser) session.getAttribute("user");
        return getUser(integratedUser, session);
    }

    private IntegratedUser getUser(IntegratedUser integratedUser, HttpSession session) {
        if(integratedUser == null) {
            try {
                OAuth2AuthenticationToken authentication = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
                Map<String, Object> map = authentication.getPrincipal().getAttributes();
                IntegratedUser convertUser = convertUser(authentication.getAuthorizedClientRegistrationId(), map);

                integratedUser = integratedUserRepository.findByEmail(convertUser.getEmail());
                if (integratedUser == null) { integratedUser = integratedUserRepository.save(convertUser); }

                setRoleIfNotSame(integratedUser, authentication, map);
                session.setAttribute("user", integratedUser);
            } catch (ClassCastException e) {
                return integratedUser;
            }
        }
        return integratedUser;
    }

    private IntegratedUser convertUser(String authority, Map<String, Object> map) {
        if(FACEBOOK.isEquals(authority)) return getModernUser(FACEBOOK, map);
        else if(GOOGLE.isEquals(authority)) return getModernUser(GOOGLE, map);
        else if(KAKAO.isEquals(authority)) return getKaKaoUser(map);
        return null;
    }

    private IntegratedUser getModernUser(SocialType socialType, Map<String, Object> map) {
        return IntegratedUser.builder()
                .name(String.valueOf(map.get("name")))
                .email(String.valueOf(map.get("email")))
                .pincipal(String.valueOf(map.get("id")))
                .socialType(socialType)
                .createdDate(LocalDateTime.now())
                .build();
    }

    private IntegratedUser getKaKaoUser(Map<String, Object> map) {
        Map<String, String> propertyMap = (HashMap<String, String>) map.get("properties");
        return IntegratedUser.builder()
                .name(propertyMap.get("nickname"))
                .email(String.valueOf(map.get("kaccount_email")))
                .pincipal(String.valueOf(map.get("id")))
                .socialType(KAKAO)
                .createdDate(LocalDateTime.now())
                .build();
    }

    private void setRoleIfNotSame(IntegratedUser user, OAuth2AuthenticationToken authentication, Map<String, Object> map) {
        if(!authentication.getAuthorities().contains(new SimpleGrantedAuthority(user.getSocialType().getRoleType()))) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(map, "N/A", AuthorityUtils.createAuthorityList(user.getSocialType().getRoleType())));
        }
    }
}