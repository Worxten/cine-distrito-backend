package com.udistrital.cinedistritobackend.api.infrastructure.authentication.security.services;

import com.udistrital.cinedistritobackend.api.infrastructure.authentication.models.User;
import com.udistrital.cinedistritobackend.api.infrastructure.authentication.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);

        //return new org.springframework.security.core.userdetails.User("Kevin", "123", new ArrayList<>());
    }
}
