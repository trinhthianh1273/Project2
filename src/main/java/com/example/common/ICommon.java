package com.example.common;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface ICommon<T> {
    ObservableList<T> getAll();
    T getOne(int id);
    boolean add(T obj);
    boolean update(T obj);
    boolean delete(int id);
    boolean refresh();
}
