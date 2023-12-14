package com.fivetwenty.patienttracker.controller;

import com.fivetwenty.patienttracker.repository.UserAccountRepository;
import com.fivetwenty.patienttracker.service.UserAccountService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;
    private final UserAccountService userAccountService;
    public UserAccountController(UserAccountRepository userAccountRepository, UserAccountService userAccountService) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountService = userAccountService;
    }

    @GetMapping("patient/{patientid}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Integer patientid) {
        UserAccount userAccount = userAccountService.getUserAccountById(userId);
        return ResponseEntity.ok().body(user);
    }
}