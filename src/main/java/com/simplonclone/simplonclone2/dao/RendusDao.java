package com.simplonclone.simplonclone2.dao;

import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Rendus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;

public class RendusDao {
    public void addRendu(String message, int formateurId, int briefId, int apprenantId) {

        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Rendus rendus = new Rendus();
            rendus.setMessage(message);
            rendus.setFormateurId(formateurId);
            rendus.setBriefId(briefId);
            rendus.setApprenantId(apprenantId);
            entityManager.persist(rendus);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }


    public ArrayList<Rendus> getAll(int briefId, int formateurId, int apprenantId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Rendus> rendus;
        try {
            transaction.begin();
            if (apprenantId == 0) {
                rendus = (ArrayList<Rendus>) entityManager.createQuery("SELECT r FROM Rendus r WHERE r.briefId = :briefId AND r.formateurId = :formateurId")
                        .setParameter("briefId", briefId)
                        .setParameter("formateurId", formateurId)
                        .getResultList();
            } else {
                rendus = (ArrayList<Rendus>) entityManager.createQuery("SELECT r FROM Rendus r WHERE r.briefId = :briefId AND r.formateurId = :formateurId AND r.apprenantId = :apprenantId")
                        .setParameter("briefId", briefId)
                        .setParameter("formateurId", formateurId)
                        .setParameter("apprenantId", apprenantId)
                        .getResultList();
            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return rendus;
    }
}
