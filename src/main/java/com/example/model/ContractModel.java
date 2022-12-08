package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Contract;
import javafx.collections.ObservableList;

public class ContractModel implements ICommon<Contract> {

    @Override
    public ObservableList<Contract> getAll() {
        return null;
    }

    @Override
    public Contract getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Contract obj) {
        return false;
    }

    @Override
    public boolean update(Contract obj) {
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
