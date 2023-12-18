package com.fivetwenty.patienttracker.util;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fivetwenty.patienttracker.model.UserAccount;
import com.fivetwenty.patienttracker.repository.UserAccountRepository;

public class CustomAuthManagerTest {

    private CustomAuthManager customAuthManager;
    private UserAccountRepository userRepo;

    @BeforeEach
    public void setUp() {
        userRepo = mock(UserAccountRepository.class);
        customAuthManager = new CustomAuthManager();
        customAuthManager.userRepo = userRepo;
    }

    @Test
    public void testSuccessfulAuthentication() {
        // Mocking user data for successful authentication
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("testUser");
        userAccount.setPassword("testPassword");
        userAccount.setRole("ROLE_USER");

        when(userRepo.findByUsername("testUser")).thenReturn(Optional.of(userAccount));

        Authentication authentication = new UsernamePasswordAuthenticationToken("testUser", "testPassword");
        Authentication result = customAuthManager.authenticate(authentication);

        // Assert authentication result
        assert result != null;
        assert result.getPrincipal().equals("testUser");
        assert result.getCredentials().equals("testPassword");
        assert result.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Test
    public void testInvalidPassword() {
        // Mocking user data for invalid password
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("testUser");
        userAccount.setPassword("testPassword");
        userAccount.setRole("ROLE_USER");

        when(userRepo.findByUsername("testUser")).thenReturn(Optional.of(userAccount));

        Authentication authentication = new UsernamePasswordAuthenticationToken("testUser", "wrongPassword");

        // Asserting BadCredentialsException for invalid password
        assertThrows(BadCredentialsException.class, () -> {
            customAuthManager.authenticate(authentication);
        });
    }

    @Test
    public void testInvalidUsername() {
        // Mocking scenario for invalid username
        when(userRepo.findByUsername("nonExistingUser")).thenReturn(Optional.empty());

        Authentication authentication = new UsernamePasswordAuthenticationToken("nonExistingUser", "anyPassword");

        // Asserting BadCredentialsException for invalid username
        assertThrows(BadCredentialsException.class, () -> {
            customAuthManager.authenticate(authentication);
        });
    }
}
