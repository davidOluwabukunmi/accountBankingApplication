package com.example.accountApplication.Repository;

import com.example.accountApplication.Model.UssdAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UssdAccountRepo extends JpaRepository<UssdAccount,Long> {
}
