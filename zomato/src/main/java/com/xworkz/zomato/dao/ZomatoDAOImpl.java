package com.xworkz.zomato.dao;

import com.xworkz.zomato.constants.DBConstants;
import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class ZomatoDAOImpl implements ZomatoDAO {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean save(RestaurantDTO restaurantDTO) {
        boolean saved = false;

        String sql = "insert into zomato(rName,rno,location,gstn,openDate,type,landmark,email,oNo,oName) values(?,?,?,?,?,?,?,?,?,?);";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, restaurantDTO.getRName());
            statement.setString(2, restaurantDTO.getRNo());
            statement.setString(3, restaurantDTO.getLoc());
            statement.setString(4, restaurantDTO.getGstn());
            statement.setString(5, restaurantDTO.getOpenDate());

            statement.setString(6, restaurantDTO.getType());
            statement.setString(7, restaurantDTO.getLandmark());
            statement.setString(8, restaurantDTO.getEmail());
            statement.setLong(9, restaurantDTO.getONo());
            statement.setString(10, restaurantDTO.getOName());

            int rows = statement.executeUpdate();

            if (rows == 1) {
                saved = true;
            } else {
                saved = false;
            }return saved;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkExist(CheckExistEmailDTO checkExistEmailDTO) {
        boolean exist=true;

        String sql="select 1 from zomato where email=?; ";
        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,checkExistEmailDTO.getEmail());

           ResultSet set= statement.executeQuery();
            System.out.println("connection started");
           if (!set.next()){

               exist=false;
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return exist;
    }
}