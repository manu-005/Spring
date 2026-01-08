package com.xworkz.eventSystem.dao;

import com.xworkz.eventSystem.entity.EventEntity;

import java.util.List;

public interface EventDao {
    boolean save(EventEntity entity);

    EventEntity getById(int id);

    EventEntity getByEventName(String eventName);

    EventEntity getByManager(String manager);

    Object[] getManagerANdLocByEventName(String eventName);

    List<EventEntity> getAll();

    List<String> getLocationByTime(String s);

    List<String> getEventByManager(String manager);

    boolean editManagerBYEventNameAndTime(String manager, String eventName, String time);

    boolean editTimeByEventName(String time, String eventName);

    boolean deleteEventById(int id);

    boolean deleteEventByEventName(String eventName);
}
