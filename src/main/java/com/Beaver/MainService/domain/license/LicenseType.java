package com.Beaver.MainService.domain.license;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LicenseType {
    PRODUCT("PRODUCT", "쿠폰"),
    DIGITAL("DIGITAL", "온라인");

    private final String key;
    private final String title;
}
