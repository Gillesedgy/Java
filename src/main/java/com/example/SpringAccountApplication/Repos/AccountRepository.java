package com.example.SpringAccountApplication.Repos;


import java.util.List;

import com.example.SpringAccountApplication.Entities.Account;

public interface AccountRepository {
    List<Account> getAllAccounts();

    Account findAccountById(int id);

    void saveAccount(Account account);

    void batchInsert(List<Account> accounts);}
