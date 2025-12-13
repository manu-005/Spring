package com.xworkz.dependencyInjection.components.restorant;

import com.xworkz.dependencyInjection.components.bike.Helmate;
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
public class Restorant {

    @Autowired
    Kitchen kitchen;

    @Value("Nandan Palace")
    private String restorantName;

    @Value("BEL road")
    private String location;
}
