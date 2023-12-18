package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
}