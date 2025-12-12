package com.xworkz.tvSystem.terminal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Setter
@Getter
//@ToString
@Component
@Scope("prototype")
public class Terminal {

    private int tId;
    private String terminalName;
    private int  number;
}
