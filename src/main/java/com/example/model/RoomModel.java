package com.example.model;

import com.example.common.ICommon;
import com.example.entity.Room;
import javafx.collections.ObservableList;

public class RoomModel implements ICommon<Room> {
    @Override
    public ObservableList<Room> getAll() {
        return null;
    }

    @Override
    public Room getOne(int id) {
        return null;
    }

    @Override
    public boolean add(Room obj) {
        return false;
    }

    @Override
    public boolean update(Room obj) {
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
