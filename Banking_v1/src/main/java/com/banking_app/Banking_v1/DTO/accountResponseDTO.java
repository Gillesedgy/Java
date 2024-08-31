package com.banking_app.Banking_v1.DTO;


import com.banking_app.Banking_v1.Entity.Transaction;

import java.util.List;

public record accountResponseDTO(Long number, int sortCode, String name, Double openingBalance, List<Transaction> transactions, Double balance, Long customer){}

