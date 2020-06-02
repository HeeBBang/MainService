package com.Beaver.MainService.domain.license;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;

@Getter
@RequiredArgsConstructor
public enum LicenseType {
    PERMANENT("LICENSE_PERMANENT", "영구"),
    ONE_YEAR("LICENSE_ONE_YEAR", "1년"),
    MARKETING("LICENSE_MARKETING", "마케팅"),
    TEST("LICENSE_TEST", "테스트");

    private final String key;
    private final String title;
}
