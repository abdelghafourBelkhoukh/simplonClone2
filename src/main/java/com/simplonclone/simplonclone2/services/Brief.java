package com.simplonclone.simplonclone2.services;

import com.simplonclone.simplonclone2.dao.BriefDao;

import java.util.ArrayList;

public class Brief {
    public ArrayList<com.simplonclone.simplonclone2.entity.Brief> getAll() {
        com.simplonclone.simplonclone2.dao.BriefDao briefDao = new com.simplonclone.simplonclone2.dao.BriefDao();
        return briefDao.getAll();
    }


    public void assignBriefToPromo(int promoId, int briefId) {
        BriefDao briefDao = new BriefDao();
        briefDao.assignBriefToPromo(promoId, briefId);
    }
}
