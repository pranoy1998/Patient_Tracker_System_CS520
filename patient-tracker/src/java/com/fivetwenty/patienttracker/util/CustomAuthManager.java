package com.fivetwenty.patienttracker.util;


import com.fivetwenty.patienttracker.model.UserAccount;
import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthManager implements AuthenticationManager {

    @Autowired
    UserAccountRepository userRepo;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Optional<UserAccount> user = userRepo.findByUsername(authentication.getName());
        if (user.isPresent()) {
//            if (passwordEncoder.matches(authentication.getCredentials().toString(), user.get().getPassword())) {
            if (authentication.getCredentials().toString().equals(user.get().getPassword())) {
                List<SimpleGrantedAuthority> list = new ArrayList<>();
                list.add(new SimpleGrantedAuthority(user.get().getRole()));
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), list);
            } else {
                throw new BadCredentialsException("Wrong Password");
            }
        } else {
            throw new BadCredentialsException("Wrong UserName");
        }
    }
}