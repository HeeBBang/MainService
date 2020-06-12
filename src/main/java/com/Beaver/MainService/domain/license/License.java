package com.Beaver.MainService.domain.license;

import com.Beaver.MainService.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class License extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Coupon Code
    @Column(length = 20, nullable = false)
    private String code;

    //License Item
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseItem item;

    //License Product
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseProduct product;

    //License Product
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseType type;

    @Column(nullable = false)
    private int licensePeriod;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expireDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @Column
    private Long userId;

    @Builder
    public License(String code,
                   LicenseItem item, LicenseProduct product, LicenseType type,
                   int licensePeriod) {
        this.code = code;
        this.item = item;
        this.product = product;
        this.type = type;
        this.licensePeriod = licensePeriod;
    }

}
