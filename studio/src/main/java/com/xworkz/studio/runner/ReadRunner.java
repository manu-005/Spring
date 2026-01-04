package com.xworkz.studio.runner;

import com.xworkz.studio.dto.BookSlotDTO;
import com.xworkz.studio.service.StudioService;
import com.xworkz.studio.service.StudioServiceImpl;

public class ReadRunner {
    public static void main(String[] args) {

        StudioService service = new StudioServiceImpl();
        BookSlotDTO dto = new BookSlotDTO();
        dto.setId(101);
       int id = dto.getId();
BookSlotDTO byId = service.getBookedSlots(id);
        System.out.println("Data Bases on id :"+id+"->"+byId);
    }
}
