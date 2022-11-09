package com.simplonclone.simplonclone2.services;
import com.simplonclone.simplonclone2.dao.*;

import java.util.ArrayList;

public class Rendus {
    public void addRendu(String message, int promoId, int briefId, int apprenantId) {
        int formateurId = getFormateurId(promoId);
        RendusDao rendusDao = new RendusDao();
        rendusDao.addRendu(message, formateurId, briefId, apprenantId);
    }

    private int getFormateurId(int promoId) {
        FormateurDao formateurDao = new FormateurDao();
        return formateurDao.getFormateurId(promoId);
    }


    public ArrayList<com.simplonclone.simplonclone2.entity.Rendus> getAll(int briefId, int promoId, int apprenantId) {
        int formateurId = getFormateurId(promoId);
        RendusDao rendusDao = new RendusDao();
        ArrayList<com.simplonclone.simplonclone2.entity.Rendus> rendus = rendusDao.getAll(briefId, formateurId, apprenantId);
        return rendus;
    }
}
