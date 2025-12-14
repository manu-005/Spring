package com.xworkz.dependencyInjection.components.house;

import com.xworkz.dependencyInjection.components.hotel.Room;
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
public class House {

    @Autowired
    Door door;

    @Value(" Akshya Nilaya")
    private String homeName;

    @Value("kempapura")
    private String address;
}
