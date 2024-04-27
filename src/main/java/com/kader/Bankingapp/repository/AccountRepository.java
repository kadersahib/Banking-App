package com.kader.Bankingapp.repository;

import com.kader.Bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
