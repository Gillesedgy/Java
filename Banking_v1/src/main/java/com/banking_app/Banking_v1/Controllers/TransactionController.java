package com.banking_app.Banking_v1.Controllers;

import com.banking_app.Banking_v1.DTO.TransactionResponseDTO;
import com.banking_app.Banking_v1.DTO.createTransactionRequestDTO;
import com.banking_app.Banking_v1.Services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody createTransactionRequestDTO request) {
        TransactionResponseDTO response = transactionService.processTransaction(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}