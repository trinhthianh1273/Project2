package com.example.controller;

import com.example.entity.Room;
import com.example.model.ApartmentModel;
import com.example.model.RoomModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomAddController implements Initializable {
    @FXML
    private Button addBtn;

    @FXML
    private ComboBox<String> apartmentField;

    @FXML
    private ComboBox<Integer> floorField;

    @FXML
    private ImageView img;

    @FXML
    private Spinner<Integer> memberMax;

    @FXML
    private TextField roomField;

    @FXML
    private Spinner<Integer> rental;

    @FXML
    private Button resetBtn;

    private String nameApartmentSelected;
    private int floorSelected;

    @FXML
    void add(MouseEvent event) {
        Room room = new Room();

        String room_name = roomField.getText();
        System.out.println(room_name);

        if(room_name != null) {
            // apartment_id, name, floor, member_max, rental, status
            String apartment_name = apartmentField.getValue();
            room.setName(room_name);
            room.setApartment_id(new ApartmentModel().getIdByName(apartment_name));
            room.setFloor(floorField.getValue());
            room.setMember_max(memberMax.getValue());
            room.setRental(rental.getValue());
            room.setStatus(0);

            boolean addStatus = new RoomModel().add(room);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (addStatus) {
                alert.setTitle("Add Room Status");
                alert.setHeaderText("Add Successfully");
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.close();
                    }
                });
            }
        }

    }

    @FXML
    void reset(MouseEvent event) {
        roomField.setText("");

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 0);
        memberMax.setValueFactory(valueFactory);

        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000000, 0, 100000);
        rental.setValueFactory(valueFactory);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        apartmentField.setPromptText("Choose Apartment");
        floorField.setPromptText("Choose Floor");
        apartmentField.setItems(optionsName);

        apartmentField.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                nameApartmentSelected = apartmentField.getValue();
                int floor_quanty = new ApartmentModel().countFloor(nameApartmentSelected);
                ObservableList<Integer> FloorField = FXCollections.observableArrayList();;
                for(int i=1; i<=floor_quanty; i++) {
                    FloorField.add(new Integer(i));
                }

                floorField.setItems(FloorField);
                System.out.println(FloorField);
            }
        });

        floorField.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer s, Integer t1) {
                floorSelected = floorField.getValue();
            }
        });

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4);
        valueFactory.setValue(1);
        memberMax.setValueFactory(valueFactory);

        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000000, 0, 100000);
        //valueFactory.setValue(0);
        rental.setValueFactory(valueFactory);
    }
}
