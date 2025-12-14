package com.xworkz.dependencyInjection.components.mall;

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
public class Shop {
    @Value("KFC")
    private String shopName;

    @Value("4 th florr")
    private String floor;
}
