package com.xworkz.studio.dao;

import com.xworkz.studio.dto.BookSlotDTO;
import com.xworkz.studio.entity.StudioEntity;

import javax.swing.text.html.parser.Entity;

public interface StudioDAO
{

    boolean bookSlot(StudioEntity entity);

   StudioEntity  getBookedSlots(int id);
}
