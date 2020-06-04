package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseProduct;
import com.Beaver.MainService.domain.license.LicenseType;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class LicenseListResponseDto {

    private Long id;

    //Coupon Code
    private String code;

    //Coupon Type
    private LicenseType type;

    //Coupon Product
    private LicenseProduct product;

    //License Period;
    private int licensePeriod;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private String email;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public LicenseListResponseDto(License entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.type = entity.getType();
        this.product = entity.getProduct();
        this.licensePeriod = entity.getLicensePeriod();
        this.beginDate = entity.getBeginDate();
        this.endDate = entity.getEndDate();
        this.email = entity.getEmail();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();

    }
}
