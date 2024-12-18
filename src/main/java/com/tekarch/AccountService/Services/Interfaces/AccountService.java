package com.tekarch.AccountService.Services.Interfaces;

import com.tekarch.AccountService.Models.Account;

import java.util.List;

public interface AccountService
{
    Account createAccount(Account account);
    List<Account> getAllAccounts();
    List<Account> getAccountsByUserId(Long userId);
    Account updateAccount(Long accountId , Account account);
    void deleteAccount(Long accountId);
}
