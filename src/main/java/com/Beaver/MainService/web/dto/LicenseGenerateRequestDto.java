package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseItem;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LicenseGenerateRequestDto {

    private int generateNumber;
    private LicenseItem item;
    private LicenseProduct product;
    private LicenseType type;
    private int licensePeriod;

    @Builder
    public LicenseGenerateRequestDto(int generateNumber, LicenseItem item, LicenseProduct product, LicenseType type, int licensePeriod) {
        this.generateNumber = generateNumber;
        this.item = item;
        this.product = product;
        this.type = type;
        this.licensePeriod = licensePeriod;
    }

}
