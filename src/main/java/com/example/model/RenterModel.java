package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Renter;
import javafx.collections.ObservableList;

public class RenterModel implements ICommon<Renter> {
    @Override
    public ObservableList<Renter> getAll() {
        return null;
    }

    @Override
    public Renter getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Renter obj) {
        return false;
    }

    @Override
    public boolean update(Renter obj) {
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
