package com.banking_app.Banking_v1.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class createAccountRequestDTO {
    private String accountName;
    private Double openingBalance;
    private Long customerId;

}
