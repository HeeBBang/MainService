package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LicenseSaveRequestDto {
    private String code;
    private LicenseType type;
    private LicenseProduct product;
    private int licensePeriod;

    @Builder
    public LicenseSaveRequestDto(String code, LicenseType type, LicenseProduct product, int licensePeriod) {
        this.code = code;
        this.type = type;
        this.product = product;
        this.licensePeriod = licensePeriod;
    }

    public License toEntity() {
        return License.builder()
                .code(code)
                .type(type)
                .product(product)
                .licensePeriod(licensePeriod)
                .build();
    }

}