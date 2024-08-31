package com.banking_app.Banking_v1.Controllers;


import com.banking_app.Banking_v1.DTO.CustomerResponseDTO;
import com.banking_app.Banking_v1.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin

public class customerController {


    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerResponseDTO> registerCustomer(@RequestBody String request){
        CustomerResponseDTO response = customerService.registerCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerResponseDTO> getCustomers() {
        return customerService.getCustomers();
    }

//    @PostMapping
//    public UserResponseDTO registerUser(@RequestBody User user){
//        UserResponseDTO response = loginService.registerUser(user);
//        return response;
//    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long customerNumber){
        CustomerResponseDTO customerDTO = customerService.getCustomerById(customerNumber);
        return ResponseEntity.ok(customerDTO);
    }
//
//    @GetMapping("/error")
//    public String getErrorResponse(){
//        return "Testing";
//    }

    // NOTE : change void to an actual number of total balance of account when closed
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
