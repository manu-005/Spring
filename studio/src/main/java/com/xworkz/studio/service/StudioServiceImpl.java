package com.xworkz.studio.service;

import com.xworkz.studio.dao.StudioDAO;
import com.xworkz.studio.dao.StudioDAOImpl;
import com.xworkz.studio.dto.BookSlotDTO;
import com.xworkz.studio.entity.StudioEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService{

    StudioDAO studioDAO= new StudioDAOImpl();

    @Override
    public boolean bookSlot(BookSlotDTO dto) {
        StudioEntity entity =new StudioEntity();

        BeanUtils.copyProperties(dto,entity);
        return studioDAO.bookSlot(entity);

    }

    @Override
    public BookSlotDTO getBookedSlots(int id) {

 StudioEntity entity = studioDAO.getBookedSlots(id);
           BookSlotDTO dto = new BookSlotDTO();
           BeanUtils.copyProperties(entity,dto);

        return dto;
    }
}
