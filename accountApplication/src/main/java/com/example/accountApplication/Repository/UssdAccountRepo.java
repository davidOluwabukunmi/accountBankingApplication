package com.example.accountApplication.Repository;

import com.example.accountApplication.Model.UssdAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UssdAccountRepo extends JpaRepository<UssdAccount,Long> {

    @Override
    List<UssdAccount> findAllById(Iterable<Long> longs);
}
