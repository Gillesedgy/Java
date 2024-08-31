package com.banking_app.Banking_v1.Services;


import com.banking_app.Banking_v1.DTO.accountResponseDTO;
import com.banking_app.Banking_v1.DTO.createAccountRequestDTO;
import com.banking_app.Banking_v1.Entity.Account;
import com.banking_app.Banking_v1.Entity.Customer;
import com.banking_app.Banking_v1.Entity.Transaction;
import com.banking_app.Banking_v1.Repository.AccountRepository;
import com.banking_app.Banking_v1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());


    public accountResponseDTO creatingAccount(createAccountRequestDTO request) {

        Customer customer = customerRepository.getReferenceById(request.getCustomerId());

        // Account Generator:
        Long uniqueAccountNumber = uniqueAccountNumberGenerator();

        // Account Creation:
        Account openAccount = new Account();

        openAccount.setAccountNumber(uniqueAccountNumber);

        openAccount.setCustomer(customer);

        openAccount.setAccountName(request.getAccountName());

        openAccount.setOpeningBalance(request.getOpeningBalance());

        openAccount.setTransactions(new ArrayList<>());

        openAccount.setSortCode(1234);

        openAccount.setCurrentBalance(request.getOpeningBalance());

        Account savedAccount = accountRepository.save(openAccount);

        //! Persistence possible fixes: Add account to customer account list && Save customer
        customer.getAccounts().add(openAccount);
        customerRepository.save(customer);

        return new accountResponseDTO(savedAccount.getAccountNumber(), savedAccount.getSortCode(), savedAccount.getAccountName(), savedAccount.getOpeningBalance(), savedAccount.getTransactions(), savedAccount.getCurrentBalance(), request.getCustomerId());

    }

    public accountResponseDTO getAccountByID(Long accountNumber) {
        Account account = accountRepository.getReferenceById(accountNumber);

        String name = account.getAccountName();

        Long number = account.getAccountNumber();

        Double currBal = account.getCurrentBalance();

        Long cusId = account.getCustomer().getCustomerId();

        int sort = account.getSortCode();

        Double openBal = account.getOpeningBalance();

        List<Transaction> transactions = account.getTransactions();

        return new accountResponseDTO(number, sort, name, openBal, transactions, currBal, cusId);
    }

    public Double deleteAccountByID(Long accountNumber) {

        Double totalAccountBalance = accountRepository.getReferenceById(accountNumber).getCurrentBalance();

        accountRepository.deleteById(accountNumber);

        return totalAccountBalance;
    }

    //* Helper Methods that generates Unique Account Number
    private Long uniqueAccountNumberGenerator() {

        Long accountNumber;

        do {

            accountNumber = (long) (Math.random() * 1000000000L);

        } while (accountRepository.existsById(accountNumber));

        return accountNumber;

    }

}

