package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Household_good;
import javafx.collections.ObservableList;

public class Household_goodModel implements ICommon<Household_good> {

    @Override
    public ObservableList<Household_good> getAll() {
        return null;
    }

    @Override
    public Household_good getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Household_good obj) {
        return false;
    }

    @Override
    public boolean update(Household_good obj) {
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
