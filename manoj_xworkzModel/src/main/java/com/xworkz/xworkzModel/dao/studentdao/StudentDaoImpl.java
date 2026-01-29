package com.xworkz.xworkzModel.dao.studentdao;

import com.xworkz.xworkzModel.dto.studentDto.StudentDTO;
import com.xworkz.xworkzModel.dto.studentDto.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class StudentDaoImpl implements  StudentDao {

    @Autowired
    EntityManagerFactory factory;
    @Override
    public boolean saveStudent(StudentEntity entity) {

        System.out.println("entity in dao :"+entity);
//        EntityManager manager =factory.createEntityManager();
//
//        manager.getTransaction().begin();
//        manager.persist(entity);
//        manager.getTransaction().commit();
        return false;
    }
}
