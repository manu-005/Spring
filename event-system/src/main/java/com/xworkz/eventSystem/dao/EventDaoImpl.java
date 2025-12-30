package com.xworkz.eventSystem.dao;

import com.xworkz.eventSystem.entity.EventEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl implements EventDao {
    @Override
    public boolean save(EventEntity entity) {

        Configuration configuration = new Configuration();

        configuration.configure().addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();

        return true;
    }

    @Override
    public EventEntity getById(int id) {

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       EventEntity eventEntity= session.get(EventEntity.class,id);

       if (eventEntity != null){
           eventEntity.setLocation("My room");
           eventEntity.setEventName("Fail Celebration");
           eventEntity.setTime("12 AM");

           session.update(eventEntity);

           transaction.commit();
           return eventEntity;
       }

        return null;
    }
}
