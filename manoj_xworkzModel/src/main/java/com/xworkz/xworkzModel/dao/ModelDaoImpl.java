package com.xworkz.xworkzModel.dao;


import com.xworkz.xworkzModel.dto.UserDto;
import com.xworkz.xworkzModel.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
