package com.example.controller;

import com.example.model.ApartmentModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ContractAddController implements Initializable {

    @FXML
    private Spinner<?> TitcheninfraredField;

    @FXML
    private Button addBtn;

    @FXML
    private ComboBox<String> apartmentField;

    @FXML
    private Spinner<?> bedField;

    @FXML
    private Spinner<?> chairField;

    @FXML
    private Spinner<?> deskField;

    @FXML
    private DatePicker endDateField;

    @FXML
    private Spinner<?> fridgeField;

    @FXML
    private Spinner<?> potField;

    @FXML
    private DatePicker proxy_dob;

    @FXML
    private     TextField proxy_name;

    @FXML
    private DatePicker renter1_dob;

    @FXML
    private TextField renter1_name;

    @FXML
    private DatePicker renter2_dob;

    @FXML
    private TextField renter2_name;

    @FXML
    private DatePicker renter3_dob;

    @FXML
    private TextField renter3_name;

    @FXML
    private Button resetBtn;

    @FXML
    private ComboBox<?> roomField;

    @FXML
    private DatePicker startDateField;

    @FXML
    private Spinner<?> tableField;

    @FXML
    private Spinner<?> wardrobeField;

    @FXML
    void add(MouseEvent event) {

    }

    @FXML
    void reset(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        apartmentField.setPromptText("Find Apartment");
        apartmentField.setItems(optionsName);
    }
}
