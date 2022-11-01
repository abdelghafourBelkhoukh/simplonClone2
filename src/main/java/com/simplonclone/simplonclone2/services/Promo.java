package com.simplonclone.simplonclone2.services;

import com.simplonclone.simplonclone2.dao.PromoDao;
import com.simplonclone.simplonclone2.entity.Promos;

import java.util.ArrayList;

public class Promo {

    public void create(String name) {
        PromoDao promoDao = new PromoDao();
        promoDao.create(name);
    }

    public ArrayList<Promos> getAll() {
        PromoDao promoDao = new PromoDao();
        return promoDao.getAll();
    }
}
