package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
}