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

        System.out.println("before saving hoster ID :" + conferenceHosterEntity.getConferenceId());

        manager.persist(conferenceHosterEntity);
        System.out.println("after saving hoster ID :" + conferenceHosterEntity.getConferenceId());

        manager.getTransaction().commit();

        return conferenceHosterEntity;
    }

    @Override
    public List<ConferenceHosterEntity> getAllConferenceHoster() {

        EntityManager manager = null;

        try {
            manager = managerFactory.createEntityManager();

            Query query = manager.createQuery(
                    "select distinct hoster from ConferenceHosterEntity hoster LEFT JOIN FETCH hoster.delegates",
                    ConferenceHosterEntity.class
            );

            List<ConferenceHosterEntity> listOfHosterEntity = query.getResultList();

//            for (ConferenceHosterEntity hoster : listOfHosterEntity) {
//                System.out.println("Conference Title: " + hoster.getConferenceTitle());
//                System.out.println("Delegates: " + hoster.getDelegates());
//            }

            System.out.println("all conference in dao: " + listOfHosterEntity);

            return listOfHosterEntity;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
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
    @Override
    public List<DelegatesEmailEntity> getAllDelegates() {

        EntityManager entityManager = null;

        try {

            entityManager = managerFactory.createEntityManager();

            Query query =
                    entityManager.createQuery(
                            "SELECT d FROM DelegatesEmailEntity d",
                            DelegatesEmailEntity.class);

            List<DelegatesEmailEntity> allDelegates = query.getResultList();

            System.out.println("all delegates in dao :"+allDelegates);
            return allDelegates;

        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public ConferenceHosterEntity getAllConferenceHosterById(Long conferenceId) {
        System.out.println("enterd in dao ============");
        EntityManager manager = managerFactory.createEntityManager();
        ConferenceHosterEntity entity= manager.find(ConferenceHosterEntity.class,conferenceId);

        System.out.println("enetity in dao by id :"+entity);

        return entity;
    }

}
