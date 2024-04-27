package com.kader.Bankingapp.mapper;

import com.kader.Bankingapp.Dto.AccountDto;
import com.kader.Bankingapp.model.Account;

public class AccountMapper {

    public static Account mapToAccount (AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapToAccount(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
