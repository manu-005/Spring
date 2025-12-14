package com.xworkz.dependencyInjection.components.movie;

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
public class Hero {

    @Value("Lohit")
    private String actorName;

    @Value("appu boss")
    private String nickName;
}
