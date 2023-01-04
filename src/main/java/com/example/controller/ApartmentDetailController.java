package com.example.controller;

import com.example.entity.Apartment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ApartmentDetailController implements Initializable {
    @FXML
    private Label floor_quanty;

    @FXML
    private Label id;

    @FXML
    private HBox labelBox;

    @FXML
    private Label name;

    @FXML
    private Label room_quanty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setApartment(Apartment a) {
        id.setText(String.valueOf(a.getId()));
        name.setText(a.getName());
        floor_quanty.setText(String.valueOf(a.getFloor_quanty()));
        room_quanty.setText(String.valueOf(a.getRoom_quanty()));
        System.out.println(a);
    }
}
