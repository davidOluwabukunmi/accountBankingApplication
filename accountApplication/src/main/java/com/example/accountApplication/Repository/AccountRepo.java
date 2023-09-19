package com.example.accountApplication.Repository;

import com.example.accountApplication.Model.Account;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepo extends JpaRepository<Account,Long> {

    Optional<Account> findByPhoneNo (String phoneNo);


    Optional<Account> findByPin (String pin);
}
