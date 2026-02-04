package com.xworkz.xworkzModel.dao.fileDao;

import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class FileDaoImpl implements FileDao {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public boolean save(FileEntity fileEntity) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(fileEntity);
        manager.getTransaction().commit();
        return true;
    }
}
