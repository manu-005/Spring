package com.xworkz.studio.dao;

import com.xworkz.studio.dto.BookSlotDTO;
import com.xworkz.studio.entity.StudioEntity;
import com.xworkz.studio.service.StudioService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.security.auth.login.AppConfigurationEntry;

@Repository
public class StudioDAOImpl implements StudioDAO {


    @Override
    public boolean bookSlot(StudioEntity entity) {

     Configuration configuration = new Configuration();
configuration.configure();
configuration.addAnnotatedClass(StudioEntity.class);
SessionFactory sessionFactory =configuration.buildSessionFactory();
Session session =sessionFactory.openSession();
Transaction transaction =session.beginTransaction();

 session.save(entity);
transaction.commit();
return true;
    }
}
