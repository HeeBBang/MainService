package com.Beaver.MainService.domain.IntegratedUser;

import com.Beaver.MainService.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IntegratedUserRepository extends JpaRepository<IntegratedUser, Long> {

    Optional<IntegratedUser> findById(long id);
    Optional<IntegratedUser> findByUuid(String uuid);

    Optional<IntegratedUser> findByEmail(String email);
    Optional<IntegratedUser> findByGoogleEmail(String googleEmail);
    Optional<IntegratedUser> findByNaverEmail(String naverEmail);
    Optional<IntegratedUser> findByKakaoEmail(String kakaoEmail);
}
