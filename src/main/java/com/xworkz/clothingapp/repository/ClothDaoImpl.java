package com.xworkz.clothingapp.repository;


import com.xworkz.clothingapp.entity.ClothEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class ClothDaoImpl implements ClothDAO {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(ClothEntity clothEntity) {

        System.out.println("dao "+clothEntity);
        System.out.println(factory);

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(clothEntity);
        manager.getTransaction().commit();

        System.out.println("dao 2-------- "+clothEntity);


        return true;
    }

    @Override
    public ClothEntity getById(int id) {
      EntityManager manager = factory.createEntityManager();

        return manager.find(ClothEntity.class,id);
    }

    @Override
    public boolean updateById(int id, ClothEntity clothEntity) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(clothEntity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        ClothEntity clothEntity =
                entityManager.find(ClothEntity.class, id);

        if (clothEntity != null) {
            entityManager.remove(clothEntity);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public boolean updatePriceById(int id, double price) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager =
                entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        ClothEntity clothEntity =
                entityManager.find(ClothEntity.class, id);

        if (clothEntity != null) {
            clothEntity.setPrice(price);
            entityManager.merge(clothEntity);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    @Override
    public String getClothTypeByClothName(String clothName) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.type from ClothEntity ref where ref.clothName =: cName");
        query.setParameter("cName", clothName);
        String cName = (String) query.getSingleResult();
        return cName;
    }

    @Override
    public Double getClothPriceByClothName(String clothName) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.price from ClothEntity ref where ref.clothName =: cName");
        query.setParameter("cName", clothName);
        Double price = (Double) query.getSingleResult();
        return price;
    }

    @Override
    public Object[] getBrandAndPriceByClothName(String clothName) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.brand, ref.price from ClothEntity ref where ref.clothName =: cName");
        query.setParameter("cName", clothName);
        Object[] brandAndPrice = (Object[]) query.getSingleResult();
        return brandAndPrice;
    }

    @Override
    public List<String> getAllBrands() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.brand from ClothEntity ref ");
        List<String> brands = query.getResultList();
        return brands;

    }

    @Override
    public List<String> getAllClothNames() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.clothName from ClothEntity ref ");
        List<String> clothNAmes = query.getResultList();
        return clothNAmes;
    }

    @Override
    public List<ClothEntity> getAllCloths() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref");
        List<ClothEntity> entities = query.getResultList();
        return entities;
    }

    @Override
    public String getClothNameByBrand(String brand) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.clothName from ClothEntity ref where ref.brand =:brand");
        query.setParameter("brand", brand);
        String clothNAme = (String) query.getSingleResult();
        return clothNAme;

    }

    @Override
    public List<ClothEntity> getClothsByColor(String color) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref where ref.color = :color");
        query.setParameter("color", color);
        List<ClothEntity> entities = query.getResultList();
        return entities;
    }

    @Override
    public List<ClothEntity> getClothsBelowPrice(double price) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref where ref.price < :price");
        query.setParameter("price", price);
        List<ClothEntity> entities = query.getResultList();
        return entities;

    }

    @Override
    public Long getTotalClothCount() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select count(ref) from ClothEntity ref");
        Long totalCOunt = (Long) query.getSingleResult();
        return totalCOunt;
    }

    @Override
    public Double getAverageClothPrice() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select avg(ref.price) from ClothEntity ref");
        Double avgPrice = (Double) query.getSingleResult();
        return avgPrice;
    }

    @Override
    public List<ClothEntity> getClothsBySize(String size) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref where ref.size =:size");
        query.setParameter("size", size);
        List<ClothEntity> entities = query.getResultList();
        return entities;

    }

    @Override
    public List<ClothEntity> getClothsByMaterial(String material) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref where ref.material =:material");
        query.setParameter("material", material);
        List<ClothEntity> entities = query.getResultList();
        return entities;
    }

    @Override
    public List<ClothEntity> getClothsbyType(String type) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref from ClothEntity ref where ref.type =: type");
        query.setParameter("type", type);
        List<ClothEntity> entities = query.getResultList();
        return entities;
    }

    @Override
    public List<String> getAvailableClothNames() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select ref.clothName from ClothEntity ref where ref.available = true");
        List<String> available = query.getResultList();
        return available;
    }

    @Override
    public ClothEntity getByName(String clothName) {

       EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select ref from ClothEntity ref where ref.clothName =: cName");
        query.setParameter("cName", clothName);
       ClothEntity entity = (ClothEntity) query.getSingleResult();

       if (entity != null){
           return entity;
       }else return null ;

    }
}
