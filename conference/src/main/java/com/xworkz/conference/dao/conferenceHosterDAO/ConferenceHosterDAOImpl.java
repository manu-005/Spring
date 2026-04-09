package com.xworkz.conference.dao.conferenceHosterDAO;

import com.xworkz.conference.entity.admin.AdminEntity;
import com.xworkz.conference.entity.conference.ConferenceHosterEntity;
import com.xworkz.conference.entity.delegatesEmailEntity.DelegatesEmailEntity;
import com.xworkz.conference.entity.tpoDelegates.InvitedDelegatesEntity;
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


            for (ConferenceHosterEntity hoster : listOfHosterEntity) {
                System.out.println("Conference Title: " + hoster.getConferenceTitle());
//                System.out.println("Delegates: " + hoster.getAccep());


            }

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

            System.out.println("all delegates in dao :" + allDelegates);
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
        ConferenceHosterEntity entity = manager.find(ConferenceHosterEntity.class, conferenceId);

        System.out.println("enetity in dao by id :" + entity);

        return entity;
    }

    @Override
    public boolean varifyAdmin(AdminEntity adminEntity) {

        EntityManager manager = managerFactory.createEntityManager();
        AdminEntity admin = (AdminEntity) manager.createQuery("select a from AdminEntity a").getSingleResult();
        System.out.println("admin details :" + admin);
        manager.close();
        if (adminEntity.getUserName().equals(admin.getUserName()) && adminEntity.getPassword().equals(admin.getPassword())) {
            return true;
        } else return false;
    }

    @Override
    public boolean updateAcceptOrDecline(Long conferenceId, boolean updateAccept) {

        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

        Query query = manager.createQuery("update ConferenceHosterEntity e set e.acceptOrDecline = :accepted where e.conferenceId = :conferenceId");
        query.setParameter("accepted", updateAccept);   // or false
        query.setParameter("conferenceId", conferenceId);

        int updated = query.executeUpdate();

        manager.getTransaction().commit();
        manager.close();
        if (updated == 1) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public InvitedDelegatesEntity saveInvitedDelegates(InvitedDelegatesEntity invitedDelegatesEntity) {
        try {

            entityManager.persist(invitedDelegatesEntity);

            return invitedDelegatesEntity;

        } catch (Exception e) {

            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateDelegateResponse(Long conferenceId, String delegateEmail, Boolean response) {

        System.out.println("ll {{{{{{{{{{{{{{{detailss" + conferenceId + delegateEmail + response);
        Query query = entityManager.createQuery(
                "update InvitedDelegatesEntity ent " +
                        "set ent.delegateAvailability = :response " +
                        "where ent.conferenceId = :conferenceId " +
                        "and ent.delegateEmail = :delegateEmail"
        );

        query.setParameter("response", response);
        query.setParameter("conferenceId", conferenceId);
        query.setParameter("delegateEmail", delegateEmail);

        int updatedRows = query.executeUpdate();
        System.out.println("updated " + updatedRows);

        if (updatedRows == 1) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<InvitedDelegatesEntity> getAvailableTpoDelegates(String sessionEmail, Long conferenceId) {

        Query query = entityManager.createQuery(
                "select entity from InvitedDelegatesEntity entity " +
                        "where entity.conferenceId = :conferenceId " +
                        "and entity.tpoEmail = :sessionEmail"
        );
        query.setParameter("conferenceId", conferenceId);
        query.setParameter("sessionEmail", sessionEmail);
        List<InvitedDelegatesEntity> availableEntityList = query.getResultList();

        if (availableEntityList != null) {
            return availableEntityList;
        } else {
            return null;
        }
    }
}


