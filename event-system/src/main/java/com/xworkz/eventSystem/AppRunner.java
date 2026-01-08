package com.xworkz.eventSystem;

import com.xworkz.eventSystem.dto.EventDto;
import com.xworkz.eventSystem.entity.EventEntity;
import com.xworkz.eventSystem.service.EventService;
import com.xworkz.eventSystem.service.EventServiceImpl;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
//@Controller
public class AppRunner {
    public static void main(String[] args) {
        EventService eventService = new EventServiceImpl();
        EventDto dto = new EventDto();
//
        dto.setId(102);
        dto.setTime("2 PM");
        dto.setLocation("Vijayanagar");
        dto.setManager("Darshu");
        dto.setEventName("Birthday Celebration");

      boolean saved =  eventService.validAndSave(dto);

        System.out.println("saved :"+saved);

//       EventDto dto1 = eventService.getById(dto.getId());
//        System.out.println("Updated DTO :"+dto1);

//       EventDto getByEventName = eventService.getByEventNam("Vinayak Result celebration");
//        System.out.println(getByEventName);
//
//      EventDto getByManager =  eventService.getByEventManager("Shashanka");
//        System.out.println(getByManager);

//
//        //get manager and location by Evevnt Name
//
//        Object[] obj =eventService.getManagerANdLocByEventName("Fail Celebration");
//
//  for (Object o : obj){
//      System.out.println(o);
//  }

        //get All events

//     List<EventEntity> listEntity = eventService.getAll();
//
//        System.out.println(listEntity);
//
//        for (EventEntity l : listEntity)
//        {
//            System.out.println("each :");
//            System.out.println(l);
//        }
//        System.out.println("stream");
//        listEntity.stream().forEach(System.out::println);


//        get location by time
//
//        List<String> string = eventService.getLocByTime("12 AM");
//        System.out.println(string);

//        List<String> str =eventService.getEventByManager("Shashanka");
//str.stream().forEach(System.out::println);

//        System.out.println(eventService.updateManagerBYEventNameAndTime("Vinayak","Fail Celebration","12 AM"));


//        System.out.println( eventService.updateTimeByEventName("4 PM","Fail Celebration"));

//        System.out.println( eventService.deleteEventById(104));

//        System.out.println( eventService.deleteByEventName("Vinayak Result celebration"));

    }
}