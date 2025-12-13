package com.xworkz.dependencyInjection;

import com.xworkz.dependencyInjection.components.airport.Airport;
import com.xworkz.dependencyInjection.components.airport.Terminal;
import com.xworkz.dependencyInjection.components.shirt.Shirt;
import com.xworkz.dependencyInjection.components.shirt.Size;
import com.xworkz.dependencyInjection.configure.Configure;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(Configure.class);

        Shirt shirt =  applicationContext.getBean(Shirt.class);
        System.out.println(shirt);

        Shirt shirt1 =  applicationContext.getBean(Shirt.class);
        System.out.println(shirt1);

       Size size = shirt.getSize();
        System.out.println(size);

        Size size1 = shirt1.getSize();
        System.out.println(size1);

        System.out.println("---------------------------------------------------");


        Airport airport =  applicationContext.getBean(Airport.class);
        System.out.println(airport);

        Airport airport1 =  applicationContext.getBean(Airport.class);
        System.out.println(airport1);

        Terminal terminal = airport.getTerminal();
        System.out.println(terminal);

        Terminal terminal1 = airport1.getTerminal();
        System.out.println(terminal1);

        System.out.println("---------------------------------------------------");




    }
}
