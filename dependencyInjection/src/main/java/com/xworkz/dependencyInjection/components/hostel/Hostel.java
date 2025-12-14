package com.xworkz.dependencyInjection.components.hostel;

import com.xworkz.dependencyInjection.components.bike.Helmate;
import com.xworkz.dependencyInjection.components.hospital.Ward;
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
public class Hostel {

    @Autowired
    Warden warden;

    @Value("kambi hostel")
    private String hostelName;

    @Value("bharath")
    private String wardenName;
}
