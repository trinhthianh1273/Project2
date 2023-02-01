package com.example.controller;

import com.example.model.ApartmentModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RenterAddController implements Initializable {

        @FXML
        private HBox NewRenterEmail;

        @FXML
        private HBox NewRenterPhone;

        @FXML
        private Button addBtn;

        @FXML
        private TextField address;

        @FXML
        private ComboBox<?> commune;

        @FXML
        private ComboBox<?> district;

        @FXML
        private DatePicker dob;

        @FXML
        private TextField email;

        @FXML
        private ComboBox<?> gender;

        @FXML
        private TextField name;

        @FXML
        private TextField phone;

        @FXML
        private ComboBox<?> province;

        @FXML
        private Button resetBtn;

        @FXML
        void add(MouseEvent event) {

        }

        @FXML
        void reset(MouseEvent event) {

        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        }
}


