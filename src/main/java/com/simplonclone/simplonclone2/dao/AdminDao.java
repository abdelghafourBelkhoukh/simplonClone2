package com.simplonclone.simplonclone2.dao;

import com.simplonclone.simplonclone2.dao.emf.EmfSingleton;
import com.simplonclone.simplonclone2.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AdminDao {
    public Admin auth(String email, String password) {
        EmfSingleton emfSingleton = EmfSingleton.getEmfSingleton();
        EntityManager entityManager = emfSingleton.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Admin admin = entityManager.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class)
                    .setParameter("email", email)
                    .getSingleResult();

            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                System.out.println("Authentification réussie");
                //return user data
                return admin;
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
}
