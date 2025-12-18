package com.xworkz.zomato.dao;

import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;

public interface ZomatoDAO {

    boolean save(RestaurantDTO restaurantDTO);

boolean checkExist(CheckExistEmailDTO checkExistEmailDTO);
}
