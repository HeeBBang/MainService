package com.Beaver.MainService.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private long kakaoId;

    @Column
    private String kakaoNickName;

    @Column
    private long naverId;

    @Column
    private long googleId;


    /*
    @Column
    private String
*/






    @Builder
    public User(
            String name,
            String email,
            String picture,
            Role role,
            long kakaoId,
            String kakaoNickName,
            long naverId,
            long googleId) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.kakaoId = kakaoId;
        this.kakaoNickName = kakaoNickName;
        this.naverId = naverId;
        this.googleId = googleId;

    }

    public User update(String name, String picture) {
        this.name = name;
        this. picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
