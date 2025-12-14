package com.xworkz.dependencyInjection.components.drama;

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
public class Actor {


    @Value("D boss")
    private String actorName;

    @Value("challenging star")
    private String nickname;

}
