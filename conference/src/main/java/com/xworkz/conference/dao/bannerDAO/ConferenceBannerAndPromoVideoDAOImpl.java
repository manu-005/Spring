package com.xworkz.conference.dao.bannerDAO;

import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import com.xworkz.conference.entity.promoVideoEntity.ConferencePromoVideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class ConferenceBannerAndPromoVideoDAOImpl implements ConferenceBannerAndPromoVideoDAO {

    @Autowired
    EntityManagerFactory factory;

    @Override
    public ConferenceBannerEntity saveBanner(ConferenceBannerEntity bannerEntity) {

        EntityManager manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(bannerEntity);
            manager.getTransaction().commit();

            System.out.println("Saved banner details");
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            manager.close();   // VERY IMPORTANT
        }

        return bannerEntity;
    }

    @Override
    public ConferencePromoVideoEntity svaePromoVideo(ConferencePromoVideoEntity promoVideoEntity) {

        EntityManager manager =factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(promoVideoEntity);
        manager.getTransaction().commit();
        System.out.println("saved promo video details");

        return promoVideoEntity;
    }
}
