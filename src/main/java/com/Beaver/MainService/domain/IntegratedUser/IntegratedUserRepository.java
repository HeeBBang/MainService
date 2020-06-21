package com.Beaver.MainService.domain.IntegratedUser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegratedUserRepository extends JpaRepository<IntegratedUser, Long> {
    IntegratedUser findByEmail(String email);

}
