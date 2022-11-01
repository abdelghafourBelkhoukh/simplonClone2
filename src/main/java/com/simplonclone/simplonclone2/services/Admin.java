package com.simplonclone.simplonclone2.services;

import com.simplonclone.simplonclone2.dao.AdminDao;

public class Admin {
    public com.simplonclone.simplonclone2.entity.Admin auth(String email, String password) {com.simplonclone.simplonclone2.dao.ApprenantDao apprenantDao = new com.simplonclone.simplonclone2.dao.ApprenantDao();
        AdminDao adminDao = new AdminDao();
        return adminDao.auth(email, password);
    }
}
