package com.Beaver.MainService.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.ArrayList;
import java.util.List;

//@ConstructorBinding
//@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private final String tokenSecret;
    private final long tokenExpirationMsec;

    private final List<String> authorizedRedirectUris;

    public AppProperties(String tokenSecret, long tokenExpirationMsec, List<String> authorizedRedirectUris) {
        this.tokenSecret = tokenSecret;
        this.tokenExpirationMsec = tokenExpirationMsec;
        this.authorizedRedirectUris = authorizedRedirectUris;
    }

    /*
    private final Auth auth = new Auth();
    private final OAuth2 oauth2 = new OAuth2();

    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpirationMsec() {
            return tokenExpirationMsec;
        }

        public void setTokenExpirationMsec(long tokenExpirationMsec) {
            this.tokenExpirationMsec = tokenExpirationMsec;
        }
    }

    public static final class OAuth2 {
        private List<String> authorizedRedirectUris = new ArrayList<>();

        public List<String> getAuthorizedRedirectUris() {
            return authorizedRedirectUris;
        }

        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
            this.authorizedRedirectUris = authorizedRedirectUris;
            return this;
        }
    }

    public Auth getAuth() {
        return auth;
    }

    public OAuth2 getOauth2() {
        return oauth2;
    }
    */
}
