package com.xworkz.eventSystem.service;


import com.xworkz.eventSystem.dao.EventDao;
import com.xworkz.eventSystem.dao.EventDaoImpl;
import com.xworkz.eventSystem.dto.EventDto;
import com.xworkz.eventSystem.entity.EventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    EventDao eventDao = new EventDaoImpl();

    @Override
    public boolean validAndSave(EventDto dto) {
        if (dto != null) {
            EventEntity entity = new EventEntity();
            BeanUtils.copyProperties(dto, entity);
            boolean saved = eventDao.save(entity);
            System.out.println("service. saved.:" + saved);
            return saved;

        }
        return false;
    }

    @Override
    public EventDto getById(int id) {

        if (id != 0) {
            EventEntity eventEntity = eventDao.getById(id);
            EventDto dto = new EventDto();

            BeanUtils.copyProperties(eventEntity, dto);
            return dto;
        }
        return null;
    }

    @Override
    public EventDto getByEventNam(String eventName) {
        EventDto dto = new EventDto();
        if (!eventName.isEmpty()) {

            EventEntity entity = eventDao.getByEventName(eventName);
            if (entity != null) {
                BeanUtils.copyProperties(entity, dto);

            }
            return dto;
        }
        return null;
    }

    @Override
    public EventDto getByEventManager(String manager) {
        EventDto dto = new EventDto();
        if (!manager.isEmpty()) {
            EventEntity getByManager = eventDao.getByManager(manager);
            BeanUtils.copyProperties(getByManager, dto);

        }
        return dto;
    }

    @Override
    public Object[] getManagerANdLocByEventName(String eventName) {
        if (!eventName.isEmpty()) {
            Object[] obj = eventDao.getManagerANdLocByEventName(eventName);
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public List<EventEntity> getAll() {
//        List<EventDto> dtoList = new ArrayList<>();

      List<EventEntity> list =  eventDao.getAll();
//      BeanUtils.copyProperties(list,dtoList);
        return list;
    }

    @Override
    public List<String> getLocByTime(String s) {

      List<String> str =  eventDao.getLocationByTime(s);

        return  str;
    }

    @Override
    public List<String> getEventByManager(String manager) {
       List<String> str = eventDao.getEventByManager(manager);

        return str;
    }

    @Override
    public boolean updateManagerBYEventNameAndTime(String manager, String eventName, String time) {

        return eventDao.editManagerBYEventNameAndTime(manager,eventName,time);

    }

    @Override
    public boolean updateTimeByEventName(String time, String eventName) {

      return   eventDao.editTimeByEventName(time,eventName);

    }

    @Override
    public boolean deleteEventById(int id) {

        return eventDao.deleteEventById(id);
    }

    @Override
    public boolean deleteByEventName(String eventName) {
        return eventDao.deleteEventByEventName(eventName);
    }
}