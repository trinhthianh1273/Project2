package com.example.controller;

import com.example.entity.Apartment;
import com.example.entity.UserSession;
import com.example.model.ApartmentModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class ApartmentAddController implements Initializable {
    public NumberFormat numberFormat;

    @FXML
    private TextField floor_quanty;

    @FXML
    private HBox labelBox;

    @FXML
    private TextField name;

    @FXML
    private TextField room_quanty;

    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        floor_quanty.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(! t1.matches("\\d*")) {
                    floor_quanty.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        room_quanty.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(! t1.matches("\\d*")) {
                    room_quanty.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    void add(MouseEvent event) {
        Apartment apartment = new Apartment();
        apartment.setName(name.getText());
        apartment.setFloor_quanty(Integer.parseInt(floor_quanty.getText()));
        apartment.setRoom_quanty(Integer.parseInt(room_quanty.getText()));

        boolean checkNewApartment = new ApartmentModel().checkNewApartment(name.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(checkNewApartment) {
            boolean addStatus = new ApartmentModel().add(apartment);
            if(addStatus) {
                alert.setTitle("Add Apartment Status");
                alert.setHeaderText("Add Successfully");
                alert.showAndWait().ifPresent(buttonType -> {
                    if(buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        stage.close();
                    }
                });
            } else {
                alert.setTitle("Add Apartment Status");
                alert.setHeaderText("Add Fail");
                alert.showAndWait();
            }
        } else {
            alert.setTitle("Add Apartment Status");
            alert.setHeaderText("New Apartment name already exists");
            alert.showAndWait();
        }
    }

    @FXML
    void reset(MouseEvent event) {
        name.setText("");
        floor_quanty.setText("");
        room_quanty.setText("");
    }
}
