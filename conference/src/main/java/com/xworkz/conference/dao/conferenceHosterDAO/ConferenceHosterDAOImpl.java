package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class ConferenceHosterDAOImpl implements ConferenceHosterDAO {

    @Autowired
    EntityManagerFactory managerFactory;

    @Override
    public ConferenceHosterEntity saveConferenceHoster(ConferenceHosterEntity conferenceHosterEntity) {

        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        System.out.println("before saving hoster ID :"+conferenceHosterEntity.getConferenceId());

        manager.persist(conferenceHosterEntity);
        System.out.println("after saving hoster ID :"+conferenceHosterEntity.getConferenceId());

        manager.getTransaction().commit();

        return conferenceHosterEntity;
    }

    @Override
    public List<ConferenceHosterEntity> getAllConferenceHoster() {

        EntityManager manager = null;

        try {
            manager = managerFactory.createEntityManager();

            Query query = manager.createQuery("select hoster from ConferenceHosterEntity hoster",
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

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ConferenceHosterEntity findById(Long conferenceId) {

        return entityManager.find(ConferenceHosterEntity.class, conferenceId);
    }

    @Override
    public boolean saveAllDeligates(List<DelegatesEmailEntity> delegatesList) {

            for (DelegatesEmailEntity entity : delegatesList) {

                entityManager.persist(entity);
            }
            return true;
    }
}
