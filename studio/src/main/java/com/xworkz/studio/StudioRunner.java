package com.xworkz.studio;

import com.xworkz.studio.dto.BookSlotDTO;
import com.xworkz.studio.service.StudioService;
import com.xworkz.studio.service.StudioServiceImpl;

/**
 * Hello world!
 *
 */

public class StudioRunner
{
    public static void main( String[] args )
    {
        System.out.println( "Runner Started !" );

        StudioService service = new StudioServiceImpl();
        BookSlotDTO dto = new BookSlotDTO();

        dto.setId(101);
        dto.setEmail("customer@gmail.com");
        dto.setLocation("Davanagere");
dto.setMobileNo(9865765676L);
dto.setCustomerName("Manoj");
dto.setBookingFor("Car delivery");

      boolean saved =  service.bookSlot(dto);
if (saved){
    System.out.println("saved..");
}else{
    System.out.println("not saved");
}
        System.out.println( "Runner Ended !" );

    }
}
