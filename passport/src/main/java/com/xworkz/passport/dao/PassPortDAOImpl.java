package com.xworkz.passport.dao;

import com.xworkz.passport.DBConstants.DBConstants;
import com.xworkz.passport.dto.PassPortRegisterDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class PassPortDAOImpl implements PassPortDAO{


    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    @SneakyThrows
    public boolean save(PassPortRegisterDTO passPortRegisterDTO) {

        String sql ="INSERT INTO passport_user_registration(first_name, last_name, dob, user_name, email, password, hint_question, hint_answer)VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try(Connection connection = DriverManager.getConnection(DBConstants.URL.getS(),DBConstants.USERNAME.getS(),DBConstants.PWD.getS());
        PreparedStatement statement = connection.prepareStatement(sql) ) {

            statement.setString(1,passPortRegisterDTO.getFirstName());
            statement.setString(2,passPortRegisterDTO.getLastName());
            statement.setString(3,passPortRegisterDTO.getDob());
            statement.setString(4,passPortRegisterDTO.getUserName());
            statement.setString(5,passPortRegisterDTO.getEmail());
            statement.setString(6,passPortRegisterDTO.getPassword());
            statement.setString(7,passPortRegisterDTO.getHintQuestion());
            statement.setString(8,passPortRegisterDTO.getHintAnswer());

          int row =  statement.executeUpdate();

          if (row==1){
              return  true;
          }
        }
        return false;
    }
}
