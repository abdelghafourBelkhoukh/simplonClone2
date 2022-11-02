package com.simplonclone.simplonclone2.services;

import com.simplonclone.simplonclone2.dao.ApprenantDao;

import java.util.ArrayList;

public class Apprenant {
    public void create(String firstname, String lastname, String email, String password) {

        ApprenantDao apprenantDao = new ApprenantDao();
        apprenantDao.create(firstname, lastname, email, password);
    }


    public com.simplonclone.simplonclone2.entity.Apprenant auth(String email, String password) {
        System.out.println("Authentification en cours");
        ApprenantDao apprenantDao = new ApprenantDao();
        return apprenantDao.auth(email, password);
    }

    public ArrayList<com.simplonclone.simplonclone2.entity.Apprenant> getAll() {
        ApprenantDao apprenantDao = new ApprenantDao();
        return apprenantDao.getAll();
    }

    public void assignToPromo(int apprenantId, int promoId1) {
        ApprenantDao apprenantDao = new ApprenantDao();
        apprenantDao.assignToPromo(apprenantId, promoId1);
    }

    public ArrayList<com.simplonclone.simplonclone2.entity.Apprenant> getApprenantById(int promoId) {
        ApprenantDao apprenantDao = new ApprenantDao();
        return apprenantDao.getApprenantById(promoId);
    }
}
