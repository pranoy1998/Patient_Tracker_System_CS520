package com.fivetwenty.patienttracker.repository;

import com.fivetwenty.patienttracker.model.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {}
