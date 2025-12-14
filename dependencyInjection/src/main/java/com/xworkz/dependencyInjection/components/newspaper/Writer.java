package com.xworkz.dependencyInjection.components.newspaper;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")
public class Writer {
    @Value("Bharath")
    private String writerName;

    @Value("poem writer")
    private String type;
}
