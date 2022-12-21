package com.example.controller;

import com.example.entity.Apartment;
import com.example.model.ApartmentModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ApartmentController implements Initializable {
    @FXML
    private TableView<Apartment> apartment_table;

    @FXML
    private TableColumn<?, ?> eidt;

    @FXML
    private TableColumn<?, ?> floor_quanty;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> remove;

    @FXML
    private TableColumn<?, ?> room_quanty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apartment_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        floor_quanty.setCellValueFactory(new PropertyValueFactory<>("floor_quanty"));
        room_quanty.setCellValueFactory(new PropertyValueFactory<>("room_quanty"));

        ObservableList<Apartment> list = new ApartmentModel().getAll();
        System.out.println(list);
        apartment_table.setItems(list);
    }
}
