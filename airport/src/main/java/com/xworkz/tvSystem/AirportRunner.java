package com.xworkz.tvSystem;

import com.xworkz.tvSystem.Config.ConfigAirport;
import com.xworkz.tvSystem.airport.Airport;
import com.xworkz.tvSystem.terminal.Terminal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AirportRunner {
    public static void main(String[] args) {

        System.out.println("Main started");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAirport.class);

        Airport airport = applicationContext.getBean(Airport.class);

//        airport.setAirportName(" Kempegouda International Airport ");
//        airport.setAId(101);
//        airport.setLoc("Bengalore");
        System.out.println("airport default :"+airport);

        Airport airport1 = applicationContext.getBean(Airport.class);
        System.out.println("airport1 :"+airport1);
//
//        Airport airport2 = new Airport();
//        System.out.println("airport2 :"+airport2);

        Terminal terminal = new Terminal();
        System.out.println("t1 :"+terminal);


        Terminal terminal2 = new Terminal();
        System.out.println("terminal 2 :"+terminal2);


        System.out.println("main ended..");
    }
}
