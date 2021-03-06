package com.Beaver.MainService.domain.license;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LicenseProduct {

    BABY_SIGN("PRODUCT_BABY_SIGN", "베이비 사인");

    private final String key;
    private final String title;
}
