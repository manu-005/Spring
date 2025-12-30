package com.xworkz.eventSystem;

import com.xworkz.eventSystem.dto.EventDto;
import com.xworkz.eventSystem.service.EventService;
import com.xworkz.eventSystem.service.EventServiceImpl;
import org.springframework.stereotype.Controller;

/**
 * Hello world!
 *
 */
@Controller
public class AppRunner
{
    public static void main( String[] args )
    {
        EventService eventService = new EventServiceImpl();
        EventDto dto = new EventDto();
//
        dto.setId(101);
//        dto.setTime("8 pm");
//        dto.setLocation("palace ground");
//        dto.setManager("Shashanka");
//        dto.setEventName("Vinayak Result celebration");

//      boolean saved =  eventService.validAndSave(dto);

//        System.out.println("saved :"+saved);


       EventDto dto1 = eventService.getById(dto.getId());
        System.out.println("Updated DTO :"+dto1);
    }
}
