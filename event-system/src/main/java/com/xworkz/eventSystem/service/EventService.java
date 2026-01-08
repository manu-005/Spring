package com.xworkz.eventSystem.service;

import com.xworkz.eventSystem.dto.EventDto;
import com.xworkz.eventSystem.entity.EventEntity;

import java.util.List;

public interface EventService {
    boolean validAndSave(EventDto dto);

    EventDto  getById(int id);

    EventDto getByEventNam(String failCelebration);

    EventDto getByEventManager(String shashanka);

    Object[] getManagerANdLocByEventName(String failCelebration);

    List<EventEntity> getAll();

    List<String> getLocByTime(String s);

    List<String> getEventByManager(String shashanka);

    boolean updateManagerBYEventNameAndTime(String vinayak, String failCelebration, String s);

    boolean updateTimeByEventName(String s, String failCelebration);

    boolean deleteEventById(int i);

    boolean deleteByEventName(String failCelebration);
}
