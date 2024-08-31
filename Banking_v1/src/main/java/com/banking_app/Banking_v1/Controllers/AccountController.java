package com.banking_app.Banking_v1.Controllers;


import com.banking_app.Banking_v1.DTO.accountResponseDTO;
import com.banking_app.Banking_v1.DTO.createAccountRequestDTO;
import com.banking_app.Banking_v1.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public accountResponseDTO creatingAccount(@RequestBody createAccountRequestDTO request){
        return service.creatingAccount(request);
    }

    @GetMapping("/{accountNumber}")
    public accountResponseDTO getAccountByID(@PathVariable Long accountNumber) {
        return service.getAccountByID(accountNumber);
    }

    @DeleteMapping("/{accountNumber}")
    public Double deleteAccountByID(@PathVariable Long accountNumber){
        return service.deleteAccountByID(accountNumber);
    }
}

