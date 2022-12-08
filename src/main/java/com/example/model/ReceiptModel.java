package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Receipt;
import javafx.collections.ObservableList;

public class ReceiptModel implements ICommon<Receipt> {

    @Override
    public ObservableList<Receipt> getAll() {
        return null;
    }

    @Override
    public Receipt getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Receipt obj) {
        return false;
    }

    @Override
    public boolean update(Receipt obj) {
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
