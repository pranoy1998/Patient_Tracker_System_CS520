package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAccountRepository extends CrudRepository<UserAccount, String> {
    Optional<UserAccount> findByUsername(String username);
}
