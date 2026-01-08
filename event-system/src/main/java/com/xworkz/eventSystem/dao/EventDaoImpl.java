package com.xworkz.eventSystem.dao;

import com.xworkz.eventSystem.entity.EventEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EventDaoImpl implements EventDao {
    @Override
    public boolean save(EventEntity entity) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("event");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

        return true;
    }

    @Override
    public EventEntity getById(int id) {

        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        EventEntity eventEntity = session.get(EventEntity.class, id);

        if (eventEntity != null) {
            eventEntity.setLocation("My room");
            eventEntity.setEventName("Fail Celebration");
            eventEntity.setTime("12 AM");

            session.update(eventEntity);

            transaction.commit();
            return eventEntity;
        }

        return null;
    }

    @Override
    public EventEntity getByEventName(String eventName) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("event");
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createNamedQuery("getByEventName");
        query.setParameter("name", eventName);

        EventEntity entity = (EventEntity) query.getSingleResult();


        return entity;
    }

    @Override
    public EventEntity getByManager(String manager) {

        EventEntity entity = (EventEntity) Persistence.createEntityManagerFactory("event")
                .createEntityManager().
                createNamedQuery("getByManager")
                .setParameter("man", manager).getSingleResult();

        System.out.println("runer " + entity);
        return entity;
    }

    @Override
    public Object[] getManagerANdLocByEventName(String eventName) {

        Object[] obj = (Object[]) Persistence.createEntityManagerFactory("event").createEntityManager()
                .createNamedQuery("getManagerANdLocByEventName").setParameter("name", eventName).getSingleResult();
        return obj;
    }

    @Override
    public List<EventEntity> getAll() {


        List<EventEntity> entityList = Persistence.createEntityManagerFactory("event").createEntityManager()
                .createNamedQuery("getAll").getResultList();

        System.out.println("dao:" + entityList);
        return entityList;
    }

    @Override
    public List<String> getLocationByTime(String s) {

        List<String> str = Persistence.createEntityManagerFactory("event")
                .createEntityManager().createNamedQuery("getLocationByTime")
                .setParameter("t", s).getResultList();


        return str;
    }

    @Override
    public List<String> getEventByManager(String manager) {

        List<String> str = Persistence.createEntityManagerFactory("event").createEntityManager()
                .createNamedQuery("getEventByManager").setParameter("manager", manager).getResultList();

        return str;
    }

    @Override
    public boolean editManagerBYEventNameAndTime(String manager, String eventName, String time) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("event")
                .createEntityManager();
        entityManager.getTransaction().begin();

      int rows=  entityManager.createNamedQuery("editManagerBYEventNameAndTime")
              .setParameter("man",manager).setParameter("name",eventName).setParameter("time",time)
              .executeUpdate();
        entityManager.getTransaction().commit();

        if (rows >0){
            return true;
        }

       else return false;
    }

    @Override
    public boolean editTimeByEventName(String time, String eventName) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("event")
                .createEntityManager();
        entityManager.getTransaction().begin();

        int rows=  entityManager.createNamedQuery("editTimeByEventName")
                .setParameter("time",time).setParameter("name",eventName)
                .executeUpdate();
        entityManager.getTransaction().commit();

        return rows > 0;
    }

    @Override
    public boolean deleteEventById(int id) {


        EntityManager entityManager = Persistence.createEntityManagerFactory("event")
                .createEntityManager();
        entityManager.getTransaction().begin();

        int rows=  entityManager.createNamedQuery("deleteEventById")
                .setParameter("id",id)
                .executeUpdate();
        entityManager.getTransaction().commit();

        return rows > 0;
    }

    @Override
    public boolean deleteEventByEventName(String eventName) {

        EntityManager entityManager = Persistence.createEntityManagerFactory("event")
                .createEntityManager();
        entityManager.getTransaction().begin();

        int rows=  entityManager.createNamedQuery("deleteEventByEventName")
                .setParameter("eventName",eventName)
                .executeUpdate();
        entityManager.getTransaction().commit();

        return rows > 0;

    }

}
