package com.simplonclone.simplonclone2.services;

import com.simplonclone.simplonclone2.dao.FormateurDao;

public class Formateur {

    public void create(String firstname, String lastname, String email, String password) {
        FormateurDao formateurDao = new FormateurDao();
        formateurDao.create(firstname, lastname, email, password);
    }

    public com.simplonclone.simplonclone2.entity.Formateur auth(String email, String password) {
        FormateurDao formateurDao = new FormateurDao();
        return formateurDao.auth(email, password);
    }

    public Object getAll() throws Exception{
        System.out.println("services");
        FormateurDao formateurDao = new FormateurDao();
        return formateurDao.getAll();
    }

    public void assignToPromo(int formateurId, int promoId) {
        FormateurDao formateurDao = new FormateurDao();
        formateurDao.assignToPromo(formateurId, promoId);
    }
}
