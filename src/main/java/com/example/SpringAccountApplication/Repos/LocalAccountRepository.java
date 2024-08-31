package com.example.SpringAccountApplication.Repos;


import org.springframework.stereotype.Repository;

import com.example.SpringAccountApplication.Entities.Account;
import java.util.ArrayList;
import java.util.List;


@Repository
public class LocalAccountRepository implements AccountRepository{
    List<Account> accounts= new ArrayList<>();
    public <accounts> LocalAccountRepository(){

        accounts.add(new Account(1,"Nola", 2344));
        accounts.add(new Account(2,"Bebe", 2345));
        accounts.add(new Account(3,"Baba", 2346));
        accounts.add(new Account(4, "McGrowen", 2347));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public Account findAccountById(int id) {
       for (Account account : accounts){
           if(account.getId() == id){
               return account;
           }
       } return null;
    }

    @Override
    public void saveAccount(Account newAccount) {
accounts.add(newAccount);
    }

    @Override
    public void batchInsert(List<Account> newAccounts) {
this.accounts.addAll(newAccounts);

    }

    @Override
    public void saveAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAccount'");
    }

}
