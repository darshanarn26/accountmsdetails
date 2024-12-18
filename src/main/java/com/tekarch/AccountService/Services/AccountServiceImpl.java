package com.tekarch.AccountService.Services;

import com.tekarch.AccountService.Models.Account;
import com.tekarch.AccountService.Repositories.AccountRepository;
import com.tekarch.AccountService.Services.Interfaces.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService
{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account)
    {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account updateAccount(Long accountId, Account accountdetails)
    {
        Account account=accountRepository.findById(accountId).orElseThrow(()->new RuntimeException("Account not found"));
        account.setAccountType(accountdetails.getAccountType());
        account.setBalance(accountdetails.getBalance());
        account.setCurrency(accountdetails.getCurrency());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long accountId)
    {
        accountRepository.deleteById(accountId);
    }


}
