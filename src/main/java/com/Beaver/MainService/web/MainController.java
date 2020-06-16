package com.Beaver.MainService.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/LicenseAdmin")
    public String licenseadmin() {
        return "license-admin";
    }

    @GetMapping("/LoginTest")
    public static String loginTest() {
        return "login-test";
    }
}
