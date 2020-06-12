package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseItem;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LicenseUpdateRequestDto {

    private String code;

    private LicenseItem item;
    private LicenseProduct product;
    private LicenseType type;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    private String userId;
}
