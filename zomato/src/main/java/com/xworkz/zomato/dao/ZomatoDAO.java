package com.xworkz.zomato.dao;

import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;

import java.util.Optional;

public interface ZomatoDAO {

    boolean save(RestaurantDTO restaurantDTO);

boolean checkExist(CheckExistEmailDTO checkExistEmailDTO);

Optional<RestaurantDTO> getByName(String name);

     Optional<RestaurantDTO> getByNameAndLoc(String searchByRestaurantName, String searchByRestaurantLocation);

    boolean updateById(RestaurantDTO restaurantDTO);
}
