package com.Beaver.MainService.domain.IntegratedUser;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class IntegratedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column(nullable = false)
    private String uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    @Column
    private String googleEmail;
    @Column
    private String googleName;

    @Column
    private String naverEmail;
    @Column
    private String naverName;

    @Column
    private String kakaoEmail;
    @Column
    private String kakaoName;

}
