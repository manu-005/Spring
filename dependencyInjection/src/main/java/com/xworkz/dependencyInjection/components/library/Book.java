package com.xworkz.dependencyInjection.components.library;

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
public class Book {

    @Value("Heli hogu Karana")
    private String bookName;

    @Value("Ravi Belakere")
    private String author;
}
