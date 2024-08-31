package com.banking_app.Banking_v1.DTO;


import com.banking_app.Banking_v1.Entity.Transaction;

public record TransactionResponseDTO(Transaction.TransactionType type, Long fromAccount, Integer fromAccountSortCode, Long toAccount, Integer toAccountSortCode, Double amount){}
