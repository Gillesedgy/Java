package com.example.SpringAccountApplication.Services;

// import javax.swing.*;

import org.springframework.stereotype.Service;

import com.example.SpringAccountApplication.Entities.Account;

import java.util.List;

@Service
public interface AccountService {

    List<Account> retrieveAllAccounts();

    Account getAccountById(int id);

    void batchInsert(List<Account> accounts);
}
