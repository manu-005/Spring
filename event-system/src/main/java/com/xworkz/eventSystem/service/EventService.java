package com.xworkz.eventSystem.service;

import com.xworkz.eventSystem.dto.EventDto;

public interface EventService {
    boolean validAndSave(EventDto dto);

    EventDto  getById(int id);
}
