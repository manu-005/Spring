package com.xworkz.xworkzModel.dao;


import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Component
public class ModelDaoImpl  implements ModelDao {

    @Autowired
    EntityManagerFactory factory ;

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
}
