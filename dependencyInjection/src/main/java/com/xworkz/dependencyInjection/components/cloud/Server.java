package com.xworkz.dependencyInjection.components.cloud;

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
public class Server {
    @Value("ibm cloud")
    private String serverName;

    @Value("100tb")
    private String storage;

}
