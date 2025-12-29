package com.xworkz.zomato.service;

import com.xworkz.zomato.dao.ZomatoDAO;
import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FormServiceImpl implements FormService {
    @Autowired
    ZomatoDAO zomatoDAO;

    @Override
    public boolean valid(RestaurantDTO restaurantDTO) {
        boolean valid = true;

        if (restaurantDTO != null) {

            if (restaurantDTO.getRName() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getRNo() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getLoc() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getGstn() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getOpenDate() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getType() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getLandmark() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getEmail() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getONo() <= 0) {
                valid = false;
            } else if (restaurantDTO.getOName() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            }

            if (valid) {

                boolean saved = zomatoDAO.save(restaurantDTO);
                if (!saved) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    @Override
    public boolean checkExit(CheckExistEmailDTO checkExistEmailDTO) {
        boolean valid = true;

        if (checkExistEmailDTO != null) {

            if (checkExistEmailDTO.getEmail().trim().isEmpty()) {
                valid = false;
            }
        }
        if (valid) {

          boolean exist=  zomatoDAO.checkExist(checkExistEmailDTO);
          if (exist){
              System.out.println("eexist");
          }else {
              valid=false;
              System.out.println("not exist");
          }
        }


        return valid;
    }

    @Override
    public Optional<RestaurantDTO> searchByName(String name) {

        if (name.trim().isEmpty()){
            return Optional.empty();
        }else{

          Optional<RestaurantDTO> dto =  zomatoDAO.getByName(name);

            return  dto;
        }

    }

    @Override
    public Optional<RestaurantDTO> searchByNameAndLoc(String searchByRestaurantName, String searchByRestaurantLocation) {

        if (searchByRestaurantName != null && searchByRestaurantLocation !=null){

            Optional<RestaurantDTO> dto =   zomatoDAO.getByNameAndLoc(searchByRestaurantName,searchByRestaurantLocation);

            return  dto;

        }

        return Optional.empty();
    }

    @Override
    public boolean updateById(RestaurantDTO restaurantDTO) {
        boolean valid = true;
        if (restaurantDTO != null) {

            if (restaurantDTO.getRName() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getRNo() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getLoc() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getGstn() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getOpenDate() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getType() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getLandmark() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getEmail() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            } else if (restaurantDTO.getONo() <= 0) {
                valid = false;
            } else if (restaurantDTO.getOName() == null || restaurantDTO.getGstn().length() < 3) {
                valid = false;
            }

        }
        if (valid) {
            boolean update = zomatoDAO.updateById(restaurantDTO);

            return update;
        }else {
            return valid;
        }}

    @Override
    public boolean delete(String rNo) {

        return zomatoDAO.delete(rNo);
    }

}
