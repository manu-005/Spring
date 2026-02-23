package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class ConferenceHosterDAOImpl implements ConferenceHosterDAO{

    @Autowired
    EntityManagerFactory managerFactory;

    @Override
    public boolean saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity) {

       EntityManager manager = managerFactory.createEntityManager();

       manager.getTransaction().begin();
//       manager.persist(conferenceHosterEntity);

        System.out.println("saved hoster in dao :"+conferenceHosterEntity);
       manager.getTransaction().commit();

        return true;
    }
}
