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

    //Coupon Type
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LicenseProduct product;

    @Column(nullable = false)
    private int licensePriode;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    @Column()
    private String email;

    @Builder
    public License(String code,
                   LicenseType type, LicenseProduct product,
                   int licensePriode) {
        this.code = code;
        this.type = type;
        this.product = product;
        this.licensePriode = licensePriode;
    }

}
