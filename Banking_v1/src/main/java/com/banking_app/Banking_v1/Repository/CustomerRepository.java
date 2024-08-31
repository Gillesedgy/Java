package com.banking_app.Banking_v1.Repository;



import com.banking_app.Banking_v1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
