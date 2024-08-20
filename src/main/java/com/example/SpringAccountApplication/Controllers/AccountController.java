package com.example.SpringAccountApplication.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.SpringAccountApplication.Entities.Account;
import com.example.SpringAccountApplication.Services.AccountService;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin

public class AccountController  {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.retrieveAllAccounts();
    }
    @GetMapping("/{id}")

    public Account getAccountById(@PathVariable int id){
        Account account = accountService.getAccountById(id);
        if(account == null){
            System.out.println("Account not found");
        }
        return account;
    }

@PostMapping("/batch")
public void insertBatchAccount(@RequestBody List<Account> accounts) {
    accountService.batchInsert(accounts);
}
}


