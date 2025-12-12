package com.xworkz.tvSystem.airport;

import com.xworkz.tvSystem.terminal.Terminal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
//@ToString
@Component
@Scope("prototype")
public class Airport {

    Terminal terminal;

    private int aId;
    private String airportName;
    private String   loc;
}
