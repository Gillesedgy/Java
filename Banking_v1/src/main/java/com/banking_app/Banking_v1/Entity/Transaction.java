package com.banking_app.Banking_v1.Entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@Table(name = "transactions")
public class Transaction {


    public enum TransactionType {
        TRANSFER, WITHDRAWAL, DEPOSIT
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transaction_id;

    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Long fromAccount;

    private Integer fromAccountSortCode;

    private Long toAccount;

    private Integer toAccountSortCode;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction(TransactionType type, Long fromAccount, Integer fromAccountSortCode, Long toAccount, Integer toAccountSortCode, Double amount) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.fromAccount = fromAccount;
        this.fromAccountSortCode = fromAccountSortCode;
        this.toAccount = toAccount;
        this.toAccountSortCode = toAccountSortCode;
        this.amount = amount;

    }

    public Transaction() {
    }
}

