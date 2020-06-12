package com.Beaver.MainService.web.dto;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseItem;
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

    //License Item
    private LicenseItem item;

    //Coupon Product
    private LicenseProduct product;

    //Coupon Type
    private LicenseType type;

    //License Period;
    private int licensePeriod;

    private LocalDateTime expireDate;

    private LocalDateTime beginDate;

    private LocalDateTime endDate;

    private Long userId;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public LicenseListResponseDto(License entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.type = entity.getType();
        this.product = entity.getProduct();
        this.licensePeriod = entity.getLicensePeriod();
        this.expireDate = entity.getExpireDateTime();
        this.beginDate = entity.getBeginDate();
        this.endDate = entity.getEndDate();
        this.userId = entity.getUserId();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();

    }
}
