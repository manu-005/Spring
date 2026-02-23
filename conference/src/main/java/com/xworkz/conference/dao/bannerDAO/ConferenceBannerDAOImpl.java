package com.xworkz.conference.dao.bannerDAO;

import com.xworkz.conference.entity.bannerEntity.ConferenceBannerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConferenceBannerDAOImpl implements ConferenceBannerDAO{

    @Autowired
    EntityManagerFactory factory;
    @Override
    public ConferenceBannerEntity saveBanner(ConferenceBannerEntity bannerEntity) {

        EntityManager manager =factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(bannerEntity);
        manager.getTransaction().commit();
        System.out.println("saved banner details");

        return bannerEntity;
    }
}
