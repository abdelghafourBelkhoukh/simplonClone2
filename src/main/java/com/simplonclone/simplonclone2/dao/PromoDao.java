package com.simplonclone.simplonclone2.dao;


import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Promos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

public class PromoDao {

    public void create(String name) {

        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Promos promo = new Promos();
            promo.setName(name);
            entityManager.persist(promo);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }

    }

    public List<Promos> getAllPromos() {
        return null;
    }

    public ArrayList<Promos> getAll() {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ArrayList<Promos> promos;
        try {
            transaction.begin();
            promos = (ArrayList<Promos>) entityManager.createQuery("SELECT p FROM Promos p").getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return promos;
    }

    public Promos getPromoById(int promoId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Promos promo;
        try {
            transaction.begin();
            promo = entityManager.createQuery("SELECT p FROM Promos p WHERE p.id = :id", Promos.class)
                    .setParameter("id", promoId)
                    .getSingleResult();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return promo;
    }
}
