package com.example.bd_rgr.security;

import com.example.bd_rgr.entity.storeDirection.UserEntity;
import com.example.bd_rgr.repository.storeDirection.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }

}