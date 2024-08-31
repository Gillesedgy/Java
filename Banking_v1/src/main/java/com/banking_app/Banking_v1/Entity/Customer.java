package com.banking_app.Banking_v1.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Setter
@Getter
@Entity
//@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",nullable = false,unique = true)
    private Long customerId;

    @Column(name="full_name",nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //! Add orphanRemoval = true : This ensures that the account gets deleted when its parent entity is also deleted
    private List<Account> accounts = new ArrayList<>();


    public Customer() {}
    public Customer(String full_name) {
        this.fullName = full_name;

        this.accounts = new ArrayList<>();
    }
    public Customer(Long customerId, String fullName, List<Account> accounts) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    }

}


