package com.banking_app.Banking_v1.DTO;



import java.util.List;


public record CustomerResponseDTO(Long id, String fullName, List<Long> accounts){}