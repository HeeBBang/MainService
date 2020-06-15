package com.Beaver.MainService.domain.service.social;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class GoogleService {

    private final RestTemplate restTemplate;
    private final Environment env;
    private final Gson gson;


    private String baseUrl;

    private String googleClientId;

    private String googleRedirect;
/*
    public GoogleProfile getGoogleProfile(String accessToken) {
        HttpHeaders header = new HttpHeaders();

        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        header.set("Authorization", "Bearer" + accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, header);

        try {
            //ResponseEntity<String> response = restTemplate.postForEntity(env.getProperty("spring.social.kakao.url.profile")), request, String.class);

        } catch (Exception e) {
            //return gson.fromJson(response);

        }
        //throw new

    }
*/
}
