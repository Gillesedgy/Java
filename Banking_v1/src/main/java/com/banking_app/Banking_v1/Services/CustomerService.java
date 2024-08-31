package com.banking_app.Banking_v1.Services;


import com.banking_app.Banking_v1.DTO.CustomerResponseDTO;
import com.banking_app.Banking_v1.Entity.Account;
import com.banking_app.Banking_v1.Entity.Customer;
import com.banking_app.Banking_v1.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponseDTO> getCustomers() {
        List<CustomerResponseDTO> response = customerRepository.findAll().stream().map(c ->
                new CustomerResponseDTO(c.getCustomerId(), c.getFullName(), new ArrayList<>())).toList();
        return response;
    }

    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Long Id = customer.getCustomerId();
        String name = customer.getFullName();
        List<Account> accounts = customer.getAccounts();
        List<Long> accountIds = accounts.stream().map(Account::getAccountNumber).collect(toList());
        CustomerResponseDTO response = new CustomerResponseDTO(Id, name, accountIds);

        return response;
    }

    public CustomerResponseDTO registerCustomer(String name) {
        Customer customer = new Customer(name);
        Customer cus = customerRepository.save(customer);
        Long id = cus.getCustomerId();
        List<Account> accounts = cus.getAccounts();
        String fullName = cus.getFullName();
        List<Long> accountNumbers = accounts.stream()
                .map(Account::getAccountNumber)
                .collect(toList());
        CustomerResponseDTO response = new CustomerResponseDTO(id, fullName, accountNumbers);
        return response;
    }


    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

}

