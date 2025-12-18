package com.xworkz.medicine.dao;

import com.xworkz.medicine.constants.DBConstants;
import com.xworkz.medicine.dto.MedicineDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class MedicineDAOImpl implements MedicineDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(MedicineDTO medicineDTO) {

        boolean saved=false;
        String sql = " insert into medicine(name,price,combination,mg,expireDate) values(?,?,?,?,?);";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS());
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,medicineDTO.getName());
            statement.setDouble(2,medicineDTO.getPrice());
            statement.setString(3,medicineDTO.getCombination());
            statement.setString(4,medicineDTO.getMg());
            statement.setString(5,medicineDTO.getExpireDate());

           int rows = statement.executeUpdate();

           if (rows == 1){
                saved = true;
           }
            return saved;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
