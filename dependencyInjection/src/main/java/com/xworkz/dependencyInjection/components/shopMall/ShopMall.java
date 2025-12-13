package com.xworkz.dependencyInjection.components.shopMall;

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
public class ShopMall {

    @Autowired
    Counter counter;

    @Value("MC")
    private String shopName;

    @Value("4")
    private String floor;
}
