package com.fivetwenty.patienttracker.service;

import static org.junit.jupiter.api.Assertions.*;

import com.fivetwenty.patienttracker.model.UserAccount;
import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class UserAccountServiceTest {

    @Test
    public void testLoadUserByUsername_UserExists() {
        // Mock UserAccountRepository
        UserAccountRepository userAccountRepository = mock(UserAccountRepository.class);

        // Create an instance of UserAccountService with the mocked repository
        UserAccountService userAccountService = new UserAccountService();
        userAccountService.userRepo = userAccountRepository;

        // Mock data for a user
        UserAccount user = new UserAccount();
        user.setUsername("testUser");
        user.setPassword("password");
        user.setRole("ROLE_USER");

        // Mock repository behavior
        when(userAccountRepository.findByUsername("testUser")).thenReturn(java.util.Optional.of(user));

        // Test when a user with the given username exists in the repository
        UserDetails userDetails = userAccountService.loadUserByUsername("testUser");
        assertNotNull(userDetails);
        assertEquals("testUser", userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_USER")));
    }

    @Test
    public void testLoadUserByUsername_UserDoesNotExist() {
        // Mock UserAccountRepository
        UserAccountRepository userAccountRepository = mock(UserAccountRepository.class);

        // Create an instance of UserAccountService with the mocked repository
        UserAccountService userAccountService = new UserAccountService();
        userAccountService.userRepo = userAccountRepository;

        // Mock repository behavior when user does not exist
        when(userAccountRepository.findByUsername("nonExistingUser")).thenReturn(java.util.Optional.empty());

        // Test when a user with the given username does not exist in the repository
        assertThrows(UsernameNotFoundException.class, () -> {
            userAccountService.loadUserByUsername("nonExistingUser");
        });
    }
}
