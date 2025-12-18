package com.xworkz.zomato.service;

import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;

public interface FormService {

    boolean valid(RestaurantDTO restaurantDTO);

    boolean checkExit(CheckExistEmailDTO checkExistEmailDTO);
}
