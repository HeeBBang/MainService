package com.Beaver.MainService.web;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.service.license.LicenseService;
import com.Beaver.MainService.web.dto.LicenseGenerateRequestDto;
import com.Beaver.MainService.web.dto.LicenseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LicenseController {
    private final LicenseService licenseService;

    @PostMapping("/api/admin/v1/license")
    public Long save(@RequestBody LicenseSaveRequestDto requestDto) {
        return licenseService.save(requestDto);
    }

    @ResponseBody
    @PostMapping("/api/admin/v1/license/generate")
    public List<License> generate(@RequestBody LicenseGenerateRequestDto requestDto, Model model) {
        return licenseService.generate(requestDto);
    }

    @PostMapping("/api/admin/v1/license/test")
    public String test() {
        return "aa";
    }

    @PostMapping("/api/admin/v1/license/search")
    public List<License> search() {
        return licenseService.getAllData();
    }
}
