package com.xworkz.xworkzModel.dao;


import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Optional;

@Component
public class ModelDaoImpl implements ModelDao {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public boolean save(UserEntity entity) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(entity);

        manager.getTransaction().commit();

        return true;
    }


    @Override
    public UserEntity checkEmailAndPassword(String email, String password) {

        EntityManager manager = factory.createEntityManager();
        try {
            Query query = manager.createQuery(
                    "from UserEntity u where u.email = :email and u.password = :password"
            );
            query.setParameter("email", email);
            query.setParameter("password", password);

            return (UserEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    @Override
    public UserEntity findByEmail(String email) {

        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select entity from UserEntity entity where entity.email=:email");
        query.setParameter("email", email);
        UserEntity entity = (UserEntity) query.getSingleResult();

        System.out.println("dao entity :" + entity);

        return entity;
    }

    @Override
    public UserEntity updateFailedAttempts(UserEntity entity) {

        System.out.println("entity dao update  :" + entity);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        UserEntity updated = manager.merge(entity);

        System.out.println("updated entity in dao :" + updated);

        manager.getTransaction().commit();
        return updated;
    }

    @Override
    public int getFailedAttemptsByDB(int id) {

        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select user.failedAttempts from UserEntity user where user.id=:id");
        query.setParameter("id", id);

        int getId = (int) query.getSingleResult();
        System.out.println("dao get id:" + getId);
        return getId;
    }

    @Override
    public boolean setAttemptsZero(int id, int failedAttempts) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("update UserEntity user set user.failedAttempts=:failedAttempts where user.id=:id");
        query.setParameter("id", id);
        query.setParameter("failedAttempts", failedAttempts);

        manager.getTransaction().commit();
        int update = query.executeUpdate();

        return update == 1;
    }

}
