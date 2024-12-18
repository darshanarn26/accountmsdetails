package com.tekarch.AccountService.Controllers;

import com.tekarch.AccountService.Models.Account;
import com.tekarch.AccountService.Services.AccountServiceImpl;
import com.tekarch.AccountService.Services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController
{
   private final AccountServiceImpl accountserviceimpl;

    public AccountController(AccountServiceImpl accountserviceimpl) {
        this.accountserviceimpl = accountserviceimpl;
    }


    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountserviceimpl.createAccount(account));
    }

    @GetMapping("/account")
    public ResponseEntity<List<Account>> getAllAccounts()
    {
        return ResponseEntity.ok(accountserviceimpl.getAllAccounts());
    }

    @GetMapping("account/{userId}")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long userId)
    {
        return ResponseEntity.ok(accountserviceimpl.getAccountsByUserId(userId));
    }

    @PutMapping("account/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId,@RequestBody Account account)
    {
        return ResponseEntity.ok(accountserviceimpl.updateAccount(accountId,account));
    }

    @DeleteMapping("account/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId)
    {
        accountserviceimpl.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
