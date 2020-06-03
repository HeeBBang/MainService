package com.Beaver.MainService.web;

import com.Beaver.MainService.domain.service.license.LicenseService;
import com.Beaver.MainService.web.dto.LicenseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LicenseController {
    private final LicenseService licenseService;

    @PostMapping("api/v1/license")
    public Long save(@RequestBody LicenseSaveRequestDto requestDto) {
        return licenseService.save(requestDto);
    }
}
