package com.Beaver.MainService.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.graalvm.compiler.lir.CompositeValue;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column//(nullable = false)
    private String name;

    @Column//(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String kakaoId;

    @Column
    private String kakaoNickName;

    @Column
    private String naverId;

    @Column
    private String naverName;

    @Column
    private String googleId;

    @Column
    private String googleName;

    @Builder
    public User(
            String name,
            String email,
            String picture,
            Role role,
            String kakaoId,
            String kakaoNickName,
            String naverId,
            String naverName,
            String googleId,
            String googleName) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.kakaoId = kakaoId;
        this.kakaoNickName = kakaoNickName;
        this.naverId = naverId;
        this.naverName = naverName;
        this.googleId = googleId;
        this.googleName = googleName;

    }

    public User kakaoUpdate(String kakaoId, String kakaoNickName) {
        this.kakaoId = kakaoId;
        this.kakaoNickName = kakaoNickName;
        this.role = Role.USER;
        return this;
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
