package com.xworkz.zomato.service;

import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;

import java.util.Optional;

public interface FormService {

    boolean valid(RestaurantDTO restaurantDTO);

    boolean checkExit(CheckExistEmailDTO checkExistEmailDTO);

    Optional<RestaurantDTO> searchByName(String name);

    Optional<RestaurantDTO> searchByNameAndLoc(String searchByRestaurantName, String searchByRestaurantLocation);

    boolean updateById(RestaurantDTO restaurantDTO);
}
