package com.xworkz.xworkzModel.dao.fileDao;

import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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

    @Override
    public String fetchFilepathById(Integer id) {

        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select file.filePath from FileEntity file where file.id=:id");
        query.setParameter("id", id);
        String filePath = query.getSingleResult().toString();
        System.out.println("file path" + filePath);

        return filePath;
    }
}
