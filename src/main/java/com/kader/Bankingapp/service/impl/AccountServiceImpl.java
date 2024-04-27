package com.kader.Bankingapp.service.impl;

import com.kader.Bankingapp.Dto.AccountDto;
import com.kader.Bankingapp.mapper.AccountMapper;
import com.kader.Bankingapp.model.Account;
import com.kader.Bankingapp.repository.AccountRepository;
import com.kader.Bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper. mapToAccount(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
       Account account =  accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccount(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =  accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
       Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccount(savedAccount);
    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account =  accountRepository.findById(id).orElseThrow(()->
                new RuntimeException("Account does not exist"));

        if(account.getBalance() < amount){
            throw  new RuntimeException("Insufficient amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccount(savedAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> AccountMapper.mapToAccount(account)).
                collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account =  accountRepository.findById(id).orElseThrow(()->
                new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
    }
}
