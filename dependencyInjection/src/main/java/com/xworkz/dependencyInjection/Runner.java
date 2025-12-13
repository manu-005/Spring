package com.xworkz.dependencyInjection;

import com.xworkz.dependencyInjection.components.Shirt;
import com.xworkz.dependencyInjection.components.Size;
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
      String color =  shirt.getColor();
        System.out.println(color);

        Shirt shirt1 =  applicationContext.getBean(Shirt.class);

        System.out.println(shirt1);

       Size size = shirt.getSize();
        System.out.println(size);

        Size size1 = shirt1.getSize();
        System.out.println(size1);
    }
}
