package com.Beaver.MainService.web;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;



@RestController
public class SocialController {
    @GetMapping("/kakao")
    public String kakaoLoginTestPage() {
        return "kakao-test";
    }

    @GetMapping("/user")
    public String userInfo() {

        return "aa";
    }


}
