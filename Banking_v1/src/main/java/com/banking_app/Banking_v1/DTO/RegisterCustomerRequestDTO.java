package com.banking_app.Banking_v1.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterCustomerRequestDTO {
    private long customerId;
    private String fullName;

    public RegisterCustomerRequestDTO(String fullName){
        this.fullName = fullName;
    }

    public RegisterCustomerRequestDTO(){
    }

}

