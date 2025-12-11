package com.xworkz.customBean;

import com.xworkz.customBean.components.*;
import com.xworkz.customBean.config.CustomBeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class CustomBeanRunneer {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new  AnnotationConfigApplicationContext(CustomBeanConfiguration.class);


//        List<AirConditioner> b3 = applicationContext.getBean("b2", List.class);
//        b3.stream().forEach(System.out::println);
//        System.out.println("_______________________________");

        List<Laptop> b1 = applicationContext.getBean("b3", List.class);
        b1.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Bed> b4 = applicationContext.getBean("b4", List.class);
        b4.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Blanket> b5 = applicationContext.getBean("b5", List.class);
        b5.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Book> b6 = applicationContext.getBean("b6", List.class);
        b6.stream().forEach(System.out::println);
        System.out.println("_______________________________");

//        List<Camera> b1 =   applicationContext.getBean(("b1"),List.class);
//        b1.stream().forEach(System.out::println);
//        System.out.println("_______________________________");
//
//
        List<Chair> b30 = applicationContext.getBean("b7", List.class);
        b30.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Cupboard> b29 = applicationContext.getBean("b8", List.class);
        b29.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Fan> b28 = applicationContext.getBean("b9", List.class);
        b28.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Fridge> b27 = applicationContext.getBean("b10", List.class);
        b27.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Headphone> b25 = applicationContext.getBean("b11", List.class);
        b25.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Helmate> b24 = applicationContext.getBean("b12", List.class);
        b24.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<HelmateCover> b23 = applicationContext.getBean("b13", List.class);
        b23.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<KeyBoard> b22 = applicationContext.getBean("b14", List.class);
        b22.stream().forEach(System.out::println);
        System.out.println("_______________________________");


        List<MicrowaveOven> b21 = applicationContext.getBean("b16", List.class);
        b21.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Mirror> b20 = applicationContext.getBean("b17", List.class);
        b20.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Mobile> b2 = applicationContext.getBean("b18", List.class);
        b2.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Mouse> b19 = applicationContext.getBean("b19", List.class);
        b19.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<NoteBook> b18 = applicationContext.getBean("b20", List.class);
        b18.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Pen> b17 = applicationContext.getBean("b21", List.class);
        b17.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Pillow> b26 = applicationContext.getBean("b22", List.class);
        b26.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<PowerBank> b16 = applicationContext.getBean("b23", List.class);
        b16.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Printer> b15 = applicationContext.getBean("b24", List.class);
        b15.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Router> b14 = applicationContext.getBean("b25", List.class);
        b14.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Shoes> b13 = applicationContext.getBean("b26", List.class);
        b13.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<SmartWatch> b12 = applicationContext.getBean("b27", List.class);
        b12.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Speaker> b11 = applicationContext.getBean("b28", List.class);
        b11.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Table> b9 = applicationContext.getBean("b29", List.class);
        b9.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Television> b10 = applicationContext.getBean("b30", List.class);
        b10.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Umbrella> b8 = applicationContext.getBean("b31", List.class);
        b8.stream().forEach(System.out::println);
        System.out.println("_______________________________");

        List<Wallet> b7 = applicationContext.getBean("b32", List.class);
        b7.stream().forEach(System.out::println);
        System.out.println("_______________________________");

//        List<WashingMachine> b6 = applicationContext.getBean("b33", List.class);
//        b6.stream().forEach(System.out::println);
//        System.out.println("_______________________________");

//        List<Watch> b5 = applicationContext.getBean("b34", List.class);
//        b5.stream().forEach(System.out::println);
//        System.out.println("_______________________________");
//
//        List<WaterBottle> b4 = applicationContext.getBean("b35", List.class);
//        b4.stream().forEach(System.out::println);
//        System.out.println("_______________________________");
//
//


    }
}
