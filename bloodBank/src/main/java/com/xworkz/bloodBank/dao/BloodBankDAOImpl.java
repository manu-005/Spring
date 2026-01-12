package com.xworkz.bloodBank.dao;

import com.xworkz.bloodBank.DBConstants;
import com.xworkz.bloodBank.dto.BloodDonorDTO;

import com.xworkz.bloodBank.entity.DonorEntity;
import lombok.SneakyThrows;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

@Repository
public class BloodBankDAOImpl implements BloodBankDAO {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    @SneakyThrows
    public boolean saved(DonorEntity  entity) {
        System.out.println(entity);
        System.out.println(entityManagerFactory);

        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(entity);

        manager.getTransaction().commit();

        return true;
    }

    @Override
    @SneakyThrows
    public Optional<BloodDonorDTO> searchByEmail(String searchEmail) {


        String sql = "select * from donorreg where email=?;";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS()); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, searchEmail);

            ResultSet set = statement.executeQuery();

            while (set.next()) {

                int donorAccountId = set.getInt(1);
                String firstname = set.getString(2);
                String lastname = set.getString(3);
                String email = set.getString(4);
                String dob = set.getString(5);
                String userName = set.getString(6);
                String phone = set.getString(7);
                String zipCode = set.getString(8);
                String password = set.getString(9);
                String repeatePassword = set.getString(10);

                BloodDonorDTO dto = new BloodDonorDTO(donorAccountId, firstname, lastname, email, dob, userName, phone, zipCode, password, repeatePassword);
                return Optional.of(dto);
            }
        }

        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<BloodDonorDTO> getById(int id) {
        String sql = "select * from donorreg where donorAccountId=?;";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS()); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            ResultSet set = statement.executeQuery();

            while (set.next()) {

                int donorAccountId = set.getInt(1);
                String firstname = set.getString(2);
                String lastname = set.getString(3);
                String email = set.getString(4);
                String dob = set.getString(5);
                String userName = set.getString(6);
                String phone = set.getString(7);
                String zipCode = set.getString(8);
                String password = set.getString(9);
                String repeatePassword = set.getString(10);

                BloodDonorDTO dto = new BloodDonorDTO(donorAccountId, firstname, lastname, email, dob, userName, phone, zipCode, password, repeatePassword);
                return Optional.of(dto);
            }
        }

        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public boolean update(BloodDonorDTO bloodDonorDTO) {

        String sql = "update donorreg set first_name=?, last_name=?, email=?, dob=?, userName=?, phone=?,zip_code=? where email=?  ";
        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS()); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, bloodDonorDTO.getFirstName());
            statement.setString(2, bloodDonorDTO.getLastName());
            statement.setString(3, bloodDonorDTO.getEmail());
            statement.setString(4, bloodDonorDTO.getDob());
            statement.setString(5, bloodDonorDTO.getUserName());
            statement.setString(6, bloodDonorDTO.getPhone());
            statement.setString(7, bloodDonorDTO.getZipCode());
            statement.setString(8, bloodDonorDTO.getEmail());

            int row = statement.executeUpdate();

            if (row == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    @SneakyThrows
    public boolean delete(int id) {
        String sql = "delete from donorreg where donorAccountId=?;";

        try (Connection connection = DriverManager.getConnection(DBConstants.URL.getS(), DBConstants.USERNAME.getS(), DBConstants.PWD.getS()); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int row = statement.executeUpdate();

            if (row == 1) {
                return true;
            }
        }

        return false;
    }
}
