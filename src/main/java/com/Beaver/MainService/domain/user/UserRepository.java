package com.Beaver.MainService.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByKakaoId(String kakaoId);
    Optional<User> findByNaverId(String naverId);
    Optional<User> findByGoogleId(String googleId);

}
