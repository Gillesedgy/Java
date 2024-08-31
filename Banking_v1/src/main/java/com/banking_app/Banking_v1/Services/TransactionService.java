package com.banking_app.Banking_v1.Services;

import com.banking_app.Banking_v1.DTO.TransactionResponseDTO;
import com.banking_app.Banking_v1.DTO.createTransactionRequestDTO;
import com.banking_app.Banking_v1.Entity.Transaction;
import com.banking_app.Banking_v1.Entity.Account;
import com.banking_app.Banking_v1.Repository.AccountRepository;
import com.banking_app.Banking_v1.Repository.CustomerRepository;
import com.banking_app.Banking_v1.Repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired(required = false)
    Transaction transaction;


    //TODO: Currently, when a user closes an account, All accounts are automatically closed. Must create logic to only close the selected account, not all account associated with the user's account
    public void depositFunds(Long accountNumber, Double amount) {
        Account account = accountRepository.getReferenceById(accountNumber);
        account.setCurrentBalance(account.getCurrentBalance() + amount);

        transaction.setType(Transaction.TransactionType.DEPOSIT);
        transaction.setFromAccount(account.getAccountNumber());
        transaction.setAmount(amount);

        transactionRepository.save(transaction);

        accountRepository.save(account);

    }

    public TransactionResponseDTO processTransaction(createTransactionRequestDTO request) {
        TransactionResponseDTO response = switch (request.getType()) {
            case DEPOSIT -> depositFunds(request);
            case TRANSFER -> transferFunds(request);
            case WITHDRAWAL -> withdrawFunds(request);
            default -> throw new IllegalArgumentException("Invalid transaction type: " + request.getType());
        };
        return response;
    }

    public TransactionResponseDTO transferFunds(createTransactionRequestDTO request) {

        Transaction.TransactionType type = request.getType();

        Long fromAccount = request.getFromAccount();

        Integer fromAccountSortCode = request.getFromAccountSortCode();

        Long toAccount = request.getToAccount();

        Integer toAccountSortCode = request.getToAccountSortCode();

        Double amount = request.getAmount();

        Transaction transaction = new Transaction(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);

        transactionRepository.save(transaction);

        return new TransactionResponseDTO(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);
    }


    public TransactionResponseDTO depositFunds(createTransactionRequestDTO request) {

        Transaction.TransactionType type = request.getType();

        Long fromAccount = request.getFromAccount();

        Integer fromAccountSortCode = request.getFromAccountSortCode();

        Long toAccount = request.getToAccount();

        Integer toAccountSortCode = request.getToAccountSortCode();

        Double amount = request.getAmount();

        Transaction transaction = new Transaction(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);

        transactionRepository.save(transaction);

        return new TransactionResponseDTO(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);
    }


    public TransactionResponseDTO withdrawFunds(createTransactionRequestDTO request) {

        Transaction.TransactionType type = request.getType();

        Long fromAccount = request.getFromAccount();

        Integer fromAccountSortCode = request.getFromAccountSortCode();

        Long toAccount = request.getToAccount();

        Integer toAccountSortCode = request.getToAccountSortCode();

        Double amount = request.getAmount();

        Transaction transaction = new Transaction(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);

        transactionRepository.save(transaction);

        return new TransactionResponseDTO(type, fromAccount, fromAccountSortCode, toAccount, toAccountSortCode, amount);
    }

}


