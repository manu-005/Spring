package com.xworkz.passport.dao;

import com.xworkz.passport.DBConstants.DBConstants;
import com.xworkz.passport.dto.PassPortRegisterDTO;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class PassPortDAOImpl implements PassPortDAO {


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SneakyThrows
    public boolean save(PassPortRegisterDTO passPortRegisterDTO) {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(PassPortRegisterDTO.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(passPortRegisterDTO);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false;

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(PassPortRegisterDTO.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        PassPortRegisterDTO passPortRegisterDTO = session.get(PassPortRegisterDTO.class, id);

        System.out.println("dao :"+passPortRegisterDTO);
        if (passPortRegisterDTO != null) {

            session.delete(passPortRegisterDTO);
            transaction.commit();
            delete = true;
        }
        return delete;
    }


}
