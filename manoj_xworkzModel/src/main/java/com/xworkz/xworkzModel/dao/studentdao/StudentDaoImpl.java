package com.xworkz.xworkzModel.dao.studentdao;

import com.xworkz.xworkzModel.entity.responseEntity.StudentResponseEntity;
import com.xworkz.xworkzModel.entity.studentEntity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDaoImpl implements  StudentDao {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public boolean saveStudent(StudentEntity entity) {

        EntityManager manager =factory.createEntityManager();

        manager.getTransaction().begin();
        System.out.println("entity in dao :"+entity);
        manager.persist(entity);
        System.out.println("entity in dao :"+entity);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    @Override
    public List<StudentEntity> getAllStudentsByBatchId(Integer batchId) {
        EntityManager manager =factory.createEntityManager();

        Query query =manager.createQuery("select students from StudentEntity students where batchId=:batchId");
        query.setParameter("batchId",batchId);
       List<StudentEntity> entities = query.getResultList();

        System.out.println("all list in dao:"+entities);

        if (!entities.isEmpty()){
            return entities;
        }
        else return null;

    }

    @Override
    public boolean saveResponse(StudentResponseEntity studentResponseEntity) {

        System.out.println("dao response entity :"+studentResponseEntity);
        EntityManager manager =factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(studentResponseEntity);
        manager.getTransaction().commit();

        return true;
    }

    @Override
    public List<StudentResponseEntity> checkResponseExists(String studentEmail) {

        EntityManager manager =factory.createEntityManager();

        List<StudentResponseEntity> entity = manager.createQuery(
                        "select resp from StudentResponseEntity resp where resp.studentEmail = :studentEmail",
                        StudentResponseEntity.class)
                .setParameter("studentEmail", studentEmail)
                .getResultList();

            return entity;
        }


    @Override
    public boolean updateResponse(StudentResponseEntity studentResponseEntity) {
        System.out.println("dao response update entity :" + studentResponseEntity);

        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();

            manager.merge(studentResponseEntity);   // pass object

            manager.getTransaction().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
            return false;

        } finally {
            manager.close();   //  close
        }
    }

}
