package com.banking_app.Banking_v1.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "account")
public class Account {

    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY) //Removed because of method that will automatically generate unique numbers (UUID)
    @Column(nullable = false, unique = true)
    private Long accountNumber;

    private int sortCode;

    private String accountName;

    private Double openingBalance;

    private Double currentBalance;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
