package com.simplonclone.simplonclone2.dao;

abstract class DataAccessObject<T> {
    public abstract void create(T t);
    public abstract T update(T t);
    public abstract void delete(T t);
    public abstract T findById(int id);

}
