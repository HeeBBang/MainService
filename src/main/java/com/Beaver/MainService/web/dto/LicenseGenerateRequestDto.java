package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LicenseGenerateRequestDto {

    private int generateNumber;

    private LicenseType type;
    private LicenseProduct product;
    private int licensePeriod;

    @Builder
    public LicenseGenerateRequestDto(int generateNumber, LicenseType type, LicenseProduct product, int licensePeriod) {
        this.generateNumber = generateNumber;
        this.type = type;
        this.product = product;
        this.licensePeriod = licensePeriod;
    }

}
