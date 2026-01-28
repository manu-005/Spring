package com.xworkz.xworkzModel.dao.batchDao;

import com.xworkz.xworkzModel.dto.batchdto.BatchDTO;
import com.xworkz.xworkzModel.entity.batchEntity.BatchEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class BatchDaoImpl implements BatchDao {

    @Autowired
    EntityManagerFactory factory;

    public BatchDaoImpl() {
        System.out.println("batch dao impl object");
    }

    @Override
    public boolean savebatch(BatchEntity entity) {

        System.out.println("dao batch ");

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(entity);

        manager.getTransaction().commit();
        return true;
    }
}
