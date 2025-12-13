package com.xworkz.dependencyInjection.components.bank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")

public class Bank {

    @Autowired
Account account;

    @Value("SBI")
    private String bankName;

    @Value("IFSC0001")
    private String ifsc;

    @Value("56665")
    private int pincode;
}
