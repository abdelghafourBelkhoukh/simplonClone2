package com.simplonclone.simplonclone2.dao;

import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Brief;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;

public class BriefDao extends DataAccessObject<Brief> {
    @Override
    public void create(Brief brief) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            transaction.begin();
            entityManager.persist(brief);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    @Override
    public Brief update(Brief brief) {
        return null;
    }

    @Override
    public void delete(Brief brief) {

    }

    @Override
    public Brief findById(int id) {
        return null;
    }


    public ArrayList<Brief> getAll() {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Brief> briefs;
        try {
            transaction.begin();
            briefs = (ArrayList<Brief>) entityManager.createQuery("SELECT b FROM Brief b", Brief.class).getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return briefs;
    }

    public ArrayList<Brief> getAll( int promoId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Brief> briefs;
        try {
            transaction.begin();
            briefs = (ArrayList<Brief>) entityManager.createQuery("SELECT b FROM Brief b WHERE b.promoId = :promoId", Brief.class)
                    .setParameter("promoId", promoId)
                    .getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return briefs;
    }

    public void assignBriefToPromo(int promoId, int briefId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Brief brief = entityManager.find(Brief.class, briefId);
            brief.setPromoId(promoId);
            entityManager.persist(brief);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }
}


