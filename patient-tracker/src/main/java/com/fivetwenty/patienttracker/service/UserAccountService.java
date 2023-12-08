package com.fivetwenty.patienttracker.service;

import com.fivetwenty.patienttracker.model.UserAccount;
import com.fivetwenty.patienttracker.repository.UserAccountRepository;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    // Constructor-based Dependency Injection
    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    // Method to retrieve all users
    public Iterable<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    // Method to retrieve a specific patient by ID
    public UserAccount getUserAccountById(Integer userid) {
        return userAccountRepository.findById(userid)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userid));
    }

}
