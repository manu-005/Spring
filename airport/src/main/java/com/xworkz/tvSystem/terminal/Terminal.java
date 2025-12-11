package com.xworkz.tvSystem.terminal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class Terminal {

    private int tId;
    private String terminalName;
    private int  number;
}
