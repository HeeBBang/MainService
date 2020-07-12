package com.Beaver.MainService.security.oauth2;

import com.Beaver.MainService.domain.user.User;
import com.Beaver.MainService.domain.user.UserRepository;
import com.Beaver.MainService.exception.ResourceNotFoundException;
import com.Beaver.MainService.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
                );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserByIdProvider(Long id, String provider) {

        User user;

        if(provider.equals("kakao")) {
            user = userRepository.findByKakaoId(id.toString()).orElseThrow(
                    () -> new ResourceNotFoundException("User", "id", id)
            );
        }
        else if( provider.equals("naver")) {
            user = userRepository.findByNaverId(id.toString()).orElseThrow(
                    () -> new ResourceNotFoundException("User", "id", id)
            );
        }
        else if(provider.equals("google")) {
            user = userRepository.findByGoogleId(id.toString()).orElseThrow(
                    () -> new ResourceNotFoundException("User", "id", id)
            );
        }
        else {
            user = userRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("User", "id", id)
            );
        }




        return UserPrincipal.create(user);
    }


}
