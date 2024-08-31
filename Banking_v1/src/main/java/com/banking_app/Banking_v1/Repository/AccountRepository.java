package com.banking_app.Banking_v1.Repository;



import com.banking_app.Banking_v1.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {

}