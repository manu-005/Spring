package com.xworkz.medicine.dao;

import com.xworkz.medicine.constants.DBConstants;
import com.xworkz.medicine.dto.MedicineDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
boolean save = false;

        Configuration configuration = new Configuration();
        configuration.configure()
                .addAnnotatedClass(MedicineDTO.class);

       SessionFactory sessionFactory = configuration.buildSessionFactory();
       Session session= sessionFactory.openSession();
       Transaction transaction =session.beginTransaction();
       session.save(medicineDTO);
       transaction.commit();
       save=true;


       return save;
    }

    @Override
    public boolean delete(String name) {
        boolean delete = false;

        Configuration configuration = new Configuration();
       Session session = configuration.configure().addAnnotatedClass(MedicineDTO.class).buildSessionFactory().openSession();
       Transaction transaction = session.beginTransaction();
       MedicineDTO dto = session.get(MedicineDTO.class,name);

       if (dto != null ){

           session.delete(dto);
           transaction.commit();
           delete = true;
       }

       return delete;
    }
}
