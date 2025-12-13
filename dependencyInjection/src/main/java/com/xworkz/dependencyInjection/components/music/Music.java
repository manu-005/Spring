package com.xworkz.dependencyInjection.components.music;

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
public class Music {

    @Autowired
    Singer singer;

    @Value("Kannada Song")
    private String songName;

    @Value("4 min")
    private String time;
}
