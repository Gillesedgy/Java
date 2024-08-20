package com.example.SpringAccountApplication.Services;
// import java.util.Optional;
// import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.SpringAccountApplication.Repos.AccountRepository;
import com.example.SpringAccountApplication.Entities.Account;



@Service
public class LocalAccountService implements AccountService {

    private AccountRepository accountRepository;

// Using Logger
    Logger logger = LoggerFactory.getLogger(LocalAccountService.class);

    public LocalAccountService(AccountRepository accountRepository) {
this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> retrieveAllAccounts() {
        logger.info("Retrieving all accounts");
        return accountRepository.getAllAccounts();
    }

    @Override
    public Account getAccountById(int id) {
return accountRepository.findAccountById(id);
    }

    @Override
    public void batchInsert(List<Account> accounts) {
        accountRepository.batchInsert(accounts);
    }
}