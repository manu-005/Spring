package com.xworkz.eventSystem.dao;

import com.xworkz.eventSystem.entity.EventEntity;

public interface EventDao {
    boolean save(EventEntity entity);

    EventEntity getById(int id);
}
