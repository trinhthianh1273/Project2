package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Manager;
import javafx.collections.ObservableList;

public class ManagerModel implements ICommon<Manager> {

    @Override
    public ObservableList<Manager> getAll() {
        return null;
    }

    @Override
    public Manager getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Manager obj) {
        return false;
    }

    @Override
    public boolean update(Manager obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean refresh() {
        return false;
    }
}
