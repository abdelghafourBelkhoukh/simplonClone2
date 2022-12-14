package com.simplonclone.simplonclone2.dao;

import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Formateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

import java.util.ArrayList;

public class FormateurDao {
    public void create(String firstname, String lastname, String email, String password) {

        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Formateur formateur = new Formateur();
            formateur.setFirstname(firstname);
            formateur.setLastname(lastname);
            formateur.setEmail(email);
            formateur.setPassword(password);
            entityManager.persist(formateur);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public Formateur auth(String email, String password) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Formateur formateur = entityManager.createQuery("SELECT a FROM Formateur a WHERE a.email = :email", Formateur.class)
                    .setParameter("email", email)
                    .getSingleResult();
            if (formateur.getEmail().equals(email) && formateur.getPassword().equals(password)) {
                System.out.println("Authentification réussie");
                //return user data
                return formateur;
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

    public ArrayList<Formateur> getAll() throws Exception{
        System.out.println("dao");
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        ArrayList<Formateur> formateurs = null;
        try {
            transaction.begin();
            formateurs = (ArrayList<Formateur>) entityManager.createQuery("SELECT f FROM Formateur f").getResultList();
//            System.out.println(formateurs);
            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }


        return formateurs;
    }

    public void assignToPromo(int formateurId, int promoId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Formateur formateur = entityManager.createQuery("SELECT a FROM Formateur a WHERE a.id = :id", Formateur.class)
                    .setParameter("id", formateurId)
                    .getSingleResult();
            formateur.setPromoId(promoId);
            entityManager.persist(formateur);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
    }

    public int getFormateurId(int promoId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Formateur formateur;
        try {
            transaction.begin();
            formateur = entityManager.createQuery("SELECT a FROM Formateur a WHERE a.promoId = :promoId", Formateur.class)
                    .setParameter("promoId", promoId)
                    .getSingleResult();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return formateur.getId();
    }

    public String getFormateurEmail(int formateurId) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Formateur formateur;
        try {
            transaction.begin();
            formateur = entityManager.createQuery("SELECT a FROM Formateur a WHERE a.id = :id", Formateur.class)
                    .setParameter("id", formateurId)
                    .getSingleResult();
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
        }
        return formateur.getEmail();
    }
}
