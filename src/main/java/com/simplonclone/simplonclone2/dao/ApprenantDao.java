package com.simplonclone.simplonclone2.dao;

import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Apprenant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;

public class ApprenantDao {
    public void create(String firstname, String lastname, String email, String password) {

        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Apprenant apprenant = new Apprenant();
            apprenant.setFirstname(firstname);
            apprenant.setLastname(lastname);
            apprenant.setEmail(email);
            apprenant.setPassword(password);
            entityManager.persist(apprenant);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public Apprenant auth(String email, String password) {
        System.out.println("Authentification en cours Dao");
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Apprenant apprenant = entityManager.createQuery("SELECT a FROM Apprenant a WHERE a.email = :email", Apprenant.class)
                    .setParameter("email", email)
                    .getSingleResult();
            if (apprenant.getEmail().equals(email) && apprenant.getPassword().equals(password)) {
                System.out.println("Authentification réussie");
                //return user data
                return apprenant;
            } else {
                System.out.println("Authentification échouée");
            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return null;
    }

    public ArrayList<Apprenant> getAll() {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Apprenant> apprenants;
        try {
            transaction.begin();
            System.out.println("1111");
            apprenants = (ArrayList<Apprenant>) entityManager.createQuery("SELECT a FROM Apprenant a").getResultList();
            transaction.commit();
            System.out.println(apprenants);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return apprenants;
    }

    public void assignToPromo(int apprenantId, int promoId1) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Apprenant apprenant = entityManager.createQuery("SELECT a FROM Apprenant a WHERE a.id = :id", Apprenant.class)
                    .setParameter("id", apprenantId)
                    .getSingleResult();
            System.out.println(apprenant);
            System.out.println("------------------------------------"+apprenantId);
            apprenant.setPromoId(promoId1);
            entityManager.persist(apprenant);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public ArrayList<Apprenant> getApprenantById(int promoId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Apprenant> apprenants;
        try {
            transaction.begin();
            apprenants = (ArrayList<Apprenant>) entityManager.createQuery("SELECT a FROM Apprenant a WHERE a.promoId = :promoId", Apprenant.class)
                    .setParameter("promoId", promoId)
                    .getResultList();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return apprenants;
    }

    public Apprenant getOneApprenantById(int apprenantId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Apprenant apprenant;
        try {
            transaction.begin();
            apprenant = entityManager.createQuery("SELECT a FROM Apprenant a WHERE a.id = :id", Apprenant.class)
                    .setParameter("id", apprenantId)
                    .getSingleResult();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return apprenant;
    }
}
