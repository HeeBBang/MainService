package com.Beaver.MainService.domain.license;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LicenseItem {
    PERMANENT("LICENSE_PERMANENT", "영구"),
    SALE("LICENSE_SALE", "판매"),
    SALE_MARKETING("LICENSE_SALE_MARKETING", "판매 마케팅"),
    BUSINESS_MARKETING("LICENSE_BUSINESS_MARKETING", "업체 마케팅"),
    TEST("LICENSE_TEST", "테스트");

    private final String key;
    private final String title;
}
