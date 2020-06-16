package com.Beaver.MainService.web;

import com.Beaver.MainService.domain.service.social.KakaoService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/social/login")
public class SocialController {

    private final Environment env;
    private final RestTemplate restTemplate;
    private final Gson gson;

    @Autowired
    private KakaoService kakaoService;

    @PostMapping("/kakao")
    public String kakaoLogin(@RequestBody Map<String, Object> code) {
        //String accessToken = kakaoService.getAccessToken(code.get("access_token").toString()).getAccess_token();
        String accessToken = kakaoService.getAccessToken(code.get("access_token").toString());
        System.out.println("controller access_token : " + accessToken);

        return "login-test";
    }

}
