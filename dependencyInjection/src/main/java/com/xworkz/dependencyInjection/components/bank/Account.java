package com.xworkz.dependencyInjection.components.bank;

import com.xworkz.dependencyInjection.components.backery.Oven;
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
public class Account {



    @Value(" Swami")
    private String accountHolderName;

    @Value("89252451")
    private int accNumber;
}
