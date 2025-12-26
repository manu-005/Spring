package com.xworkz.zomato.dao;

import com.xworkz.zomato.constants.DBConstants;
import com.xworkz.zomato.dto.CheckExistEmailDTO;
import com.xworkz.zomato.dto.RestaurantDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.management.PlatformLoggingMXBean;
import java.sql.*;
import java.util.Optional;

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
            }
            return saved;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkExist(CheckExistEmailDTO checkExistEmailDTO) {
        boolean exist = true;

        String sql = "select 1 from zomato where email=?; ";
        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, checkExistEmailDTO.getEmail());

            ResultSet set = statement.executeQuery();
            System.out.println("connection started");
            if (!set.next()) {

                exist = false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exist;
    }

    @Override
    @SneakyThrows

    public Optional<RestaurantDTO> getByName(String name) {

        String sql = "select * from zomato where rName=?; ";
        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);

            ResultSet set = statement.executeQuery();
            System.out.println("connection started");

            while (set.next()) {
                String rName = set.getString(1);
                String rNo = set.getString(2);
                String loc = set.getString(3);
                String gstn = set.getString(4);
                String opendate = set.getString(5);
                String type = set.getString(6);
                String landmark = set.getString(7);
                String email = set.getString(8);
                long oNo = set.getLong(9);
                String oName = set.getString(10);

                RestaurantDTO restaurantDTO = new RestaurantDTO(rName, rNo, loc, gstn, opendate, type, landmark, email, oNo, oName);
                return Optional.of(restaurantDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<RestaurantDTO> getByNameAndLoc(String searchByRestaurantName, String searchByRestaurantLocation) {


        String sql = "select * from zomato where rName=? and location=?";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, searchByRestaurantName);
            statement.setString(2, searchByRestaurantLocation);

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                String rName = set.getString(1);
                String rNo = set.getString(2);
                String loc = set.getString(3);
                String gstn = set.getString(4);
                String opendate = set.getString(5);
                String type = set.getString(6);
                String landmark = set.getString(7);
                String email = set.getString(8);
                long oNo = set.getLong(9);
                String oName = set.getString(10);

                RestaurantDTO restaurantDTO = new RestaurantDTO(rName, rNo, loc, gstn, opendate, type, landmark, email, oNo, oName);
                return Optional.of(restaurantDTO);
            }
        }

        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public boolean updateById(RestaurantDTO restaurantDTO) {

        String sql = "update zomato set rno=?,location=?,gstn=?,openDate=?,type=?,landmark=?,email=?,oNo=?,oName=? where rName=?;";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, restaurantDTO.getRNo());
            statement.setString(2, restaurantDTO.getLoc());
            statement.setString(3, restaurantDTO.getGstn());
            statement.setString(4, restaurantDTO.getOpenDate());

            statement.setString(5, restaurantDTO.getType());
            statement.setString(6, restaurantDTO.getLandmark());
            statement.setString(7, restaurantDTO.getEmail());
            statement.setLong(8, restaurantDTO.getONo());
            statement.setString(9, restaurantDTO.getOName());
            statement.setString(10, restaurantDTO.getRName());

            int rows = statement.executeUpdate();

            if (rows == 1) {
                return true;
            }
        }
        return false;
    }


}