package com.Beaver.MainService.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);


    private final String TokenSecret;
    private final long tokenExpirationMsec;

    private final List<String> authorizedRedirectUris = new ArrayList<>(3);

    public JwtTokenProvider() {
        this.TokenSecret = "926D96C90030DD58429D2751AC1BDBBC";
        this.tokenExpirationMsec = 864000000;
        this.authorizedRedirectUris.add("http://localhost:3000/oauth2/redirect");
        this.authorizedRedirectUris.add("myandroidapp://oauth2/redirect");
        this.authorizedRedirectUris.add("myiosapp://oauth2/redirect");
    }

    public String createToken(Authentication authentication) {


        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken)authentication;

        //aa.getPrincipal().getAttribute("id");
        //oAuth2AuthenticationToken.getPrincipal().getAttribute("id").toString();



        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + tokenExpirationMsec);

        String provider = "";

        if(oAuth2AuthenticationToken.getPrincipal().getAttributes().get("kakao_account") != null)
        {
            provider = "kakao";
        }

        return Jwts.builder()
                .setSubject(oAuth2AuthenticationToken.getPrincipal().getAttribute("id").toString())
                .setAudience(provider)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, TokenSecret)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(TokenSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(TokenSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

}