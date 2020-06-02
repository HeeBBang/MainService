package com.Beaver.MainService.domain.license;

import com.Beaver.MainService.domain.BaseTimeEntity;
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

    @Column(length = 20, nullable = false)
    private String code;

    /*
    @Column(length = 20, nullable = false)
    private String type;

    @Column(length = 20, nullable = false)
    private String issued;
    */

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

    @Column(nullable = false)
    private String email;

}
