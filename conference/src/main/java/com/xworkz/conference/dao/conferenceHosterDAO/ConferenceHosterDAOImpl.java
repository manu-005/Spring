package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class ConferenceHosterDAOImpl implements ConferenceHosterDAO{

    @Autowired
    EntityManagerFactory managerFactory;

    @Override
    public boolean saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity) {

       EntityManager manager = managerFactory.createEntityManager();

       manager.getTransaction().begin();

        System.out.println("before saving hoster ID :"+conferenceHosterEntity.getConferenceId());

        manager.persist(conferenceHosterEntity);
        System.out.println("after saving hoster ID :"+conferenceHosterEntity.getConferenceId());

        System.out.println("saved hoster in dao :"+conferenceHosterEntity);
       manager.getTransaction().commit();

        return true;
    }

    @Override
    public List<ConferenceHosterEntity> getAllConferenceHoster() {

        EntityManager manager = null;

        try {
            manager = managerFactory.createEntityManager();

            Query query =  manager.createQuery(  "select hoster from ConferenceHosterEntity hoster",
                            ConferenceHosterEntity.class
                    );

            List<ConferenceHosterEntity> listOfHosterEntity = query.getResultList();  // return actual list

            return listOfHosterEntity;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();   // avoid NullPointerException
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }
}
