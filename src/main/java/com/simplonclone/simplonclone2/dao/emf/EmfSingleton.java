package com.simplonclone.simplonclone2.dao.emf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfSingleton {
    private static final String PERSISTENCE_UNIT_NAME = "default";
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private static EmfSingleton emfSingleton;

    public static EmfSingleton getEmfSingleton()
    {
        if(emfSingleton == null)
        {
            emfSingleton = new EmfSingleton();
        }
        return emfSingleton;
    }


    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return emf.createEntityManager();
    }






//    private EmfSingleton(){
//        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
////        em = emf.createEntityManager();
//    }

//    public static EntityManager getEntityManager()
//    {
//            em = emf.createEntityManager();
//        return em;
//    }

//    public static EntityManager beginTransaction() {
//        EntityManager entityManager = getEntityManager();
//        entityManager.getTransaction().begin();
//        return entityManager;
//    }
//
//    public static void commitTransaction(EntityManager em) {
//        em.getTransaction().commit();
//    }
//
//    public static void rollbackTransaction(EntityManager em) {
//        em.getTransaction().rollback();
//    }
//
//    public static boolean isTransactionActive(EntityManager em) {
//        return em.getTransaction().isActive();
//    }
//
//
//    public void closeEntityManager(EntityManager entityManager) {
//        entityManager.close();
//    }
}
