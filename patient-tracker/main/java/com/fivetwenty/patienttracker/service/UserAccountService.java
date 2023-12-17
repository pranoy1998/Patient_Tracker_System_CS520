package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.UserAccount;
import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class UserAccountService implements UserDetailsService {

    @Autowired
    UserAccountRepository userRepo;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserAccount> userOptional = userRepo.findByUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder userBuilder;

        if (userOptional.isPresent()) {

            UserAccount user = userOptional.get();
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(username);
            userBuilder.password(user.getPassword());

            String role = user.getRole();
            userBuilder.authorities(role);
        } else {
            throw new UsernameNotFoundException("User does not exist");
        }

        return userBuilder.build();
    }
}
