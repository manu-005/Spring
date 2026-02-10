package com.xworkz.xworkzModel.dao.fileDao;

import com.xworkz.xworkzModel.entity.fileentity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class FileDaoImpl implements FileDao {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public FileEntity save(FileEntity fileEntity) {

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
      manager.persist(fileEntity);
//        System.out.println("file saved in dao :"+fileEntity);
        manager.getTransaction().commit();

        System.out.println("saved file in file table");
        System.out.println("saved file in file table, id = " + fileEntity.getFileId());

        return fileEntity;
    }

    @Override
    public String fetchFilepathById( int fileId) {

        System.out.println("dao id :"+fileId);

        if (fileId == 0) {
            System.out.println("ID is null, cannot fetch file path");
            return null;
        }

        EntityManager manager = factory.createEntityManager();
        String filePath = null;

        try {
            Query query = manager.createQuery(
                    "select f.filePath from FileEntity f where f.fileId = :fileId");
            query.setParameter("fileId", fileId);

            filePath = (String) query.getSingleResult();
            System.out.println("File path: " + filePath);

        } catch (NoResultException e) {
            System.out.println("No file found for id: " + fileId);
        } finally {
            manager.close();
        }

        return filePath;
    }
}
