package com.banking_app.Banking_v1.Repository;


import com.banking_app.Banking_v1.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
