package com.Beaver.MainService.security.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

// 최종적으로 oAuth2AuthenticationSuccessHandler가 invoke 되며, 이때 JWT Token이 생성됩니다. 이 JWT Token은 client의 redirect_uri로 Query String을 통해 전달
//1. redirection uri에 대한 validation을 수행합니다.
//2. unauthorized redirect uri로 요청이 들어온경우, 에러가 발생합니다.
//3. JWT Token을 생성합니다.
//4 user를 redirect_uri로 redirect 합니다. 이때 생성한 JWT Token을 Query String으로 전달합니다.

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Autowired
    OAuth2AuthenticationSuccessHandler(HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository) {
        this.httpCookieOAuth2AuthorizationRequestRepository = httpCookieOAuth2AuthorizationRequestRepository;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

    }

    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {


        return null;
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {

    }

    private boolean isAuthorizedRedirectUri(String uri) {

        return false;
    }


}
