package com.kader.Bankingapp.service;

import com.kader.Bankingapp.Dto.AccountDto;
import com.kader.Bankingapp.model.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withDraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}

