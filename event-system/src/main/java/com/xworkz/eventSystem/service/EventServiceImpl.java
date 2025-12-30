package com.xworkz.eventSystem.service;

import com.xworkz.eventSystem.dao.EventDao;
import com.xworkz.eventSystem.dao.EventDaoImpl;
import com.xworkz.eventSystem.dto.EventDto;
import com.xworkz.eventSystem.entity.EventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public class EventServiceImpl implements  EventService{
    EventDao eventDao = new EventDaoImpl();

    @Override
    public boolean validAndSave(EventDto dto) {
        if (dto != null){
            EventEntity entity = new EventEntity();
            BeanUtils.copyProperties(dto,entity);
      boolean saved=     eventDao.save(entity);
            System.out.println("service. saved.:"+saved);
            return  saved;

        }
        return  false;
    }

    @Override
    public EventDto getById(int id) {

        if (id!= 0){
          EventEntity eventEntity = eventDao.getById(id);
          EventDto dto = new EventDto();

          BeanUtils.copyProperties(eventEntity,dto);
          return  dto;
        }
        return null;
    }
}
