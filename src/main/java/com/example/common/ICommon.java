package com.example.common;

import java.util.ArrayList;

public interface ICommon<T> {
    ArrayList<T> getAll();
    T getOne(int id);
    boolean add(T obj);
    boolean update(T obj);
    boolean delete(int id);
}
