package com.banking_app.Banking_v1.DTO;

import com.banking_app.Banking_v1.Entity.Transaction;
import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
public class createTransactionRequestDTO {

    private Transaction.TransactionType type;
    private Long fromAccount;
    private Integer fromAccountSortCode;
    private Long toAccount;
    private Integer toAccountSortCode;;
    private Double amount;

    public createTransactionRequestDTO(Transaction.TransactionType type, Long fromAccount, Integer fromAccountSortCode, Long toAccount, Integer toAccountSortCode, Double amount) {
        this.type = type;
        this.fromAccount = fromAccount;
        this.fromAccountSortCode = fromAccountSortCode;
        this.toAccount = toAccount;
        this.toAccountSortCode = toAccountSortCode;
        this.amount = amount;
    }

    public createTransactionRequestDTO(){};


}