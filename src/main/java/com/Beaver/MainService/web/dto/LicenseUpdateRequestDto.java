package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LicenseUpdateRequestDto {

    private String code;

    private LicenseType type;
    private LicenseProduct product;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;

    private String email;
}
