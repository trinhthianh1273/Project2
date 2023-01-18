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

public class RoomDetailController implements Initializable {
    @FXML
    private ComboBox<String> apartmentField;

    @FXML
    private Button closeBtn;

    @FXML
    private ComboBox<Integer> floorField;

    @FXML
    private ImageView img;

    @FXML
    private Spinner<Integer> memberMax;

    @FXML
    private Spinner<Integer> rental;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField roomField;

    @FXML
    private Button saveBtn;

    @FXML
    private ComboBox<Integer> statusField;
    private String nameApartmentSelected;
    private int floorSelected;
    private int room_id;
    private Room root;

    @FXML
    void close(MouseEvent event) {

    }

    @FXML
    void reset(MouseEvent event) {
        System.out.println(root);
        setRoom(root);
    }

    @FXML
    void save(MouseEvent event) {
        Room room = new Room();
        int apartment_id = new ApartmentModel().getIdByName(apartmentField.getValue());
        //System.out.println(apartment_id);
        //apartment_id = ?, name = ?, floor = ?, member_max = ?, rental =?, status = ?
        room.setApartment_id(apartment_id);
        room.setApartment_name(apartmentField.getValue());
        room.setName(roomField.getText());
        room.setFloor(floorField.getValue());
        room.setMember_max(memberMax.getValue());
        room.setRental(rental.getValue());
        room.setStatus(statusField.getValue());
        room.setId(room_id);

        System.out.println(room);

        boolean updateStatus = new RoomModel().update(room);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (updateStatus) {
            alert.setTitle("Update Room Status");
            alert.setHeaderText("Update Successfully");
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                }
            });
        } else {
            alert.setTitle("Update Room Status");
            alert.setHeaderText("Update Fail");
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                }
            });
        }
    }

    public void setRoom(Room room) {
        root = room;
        room_id = room.getId();
        System.out.println(room);

        roomField.setText(room.getName());

        ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        apartmentField.setItems(optionsName);
        apartmentField.setValue(room.getApartment_name());
        floorField.setValue(room.getFloor());

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


        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000000, 0, 100000);
        valueFactory.setValue(room.getRental());
        rental.setValueFactory(valueFactory);

        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 0);
        valueFactory.setValue(room.getMember_max());
        memberMax.setValueFactory(valueFactory);

        ObservableList<Integer> list = FXCollections.observableArrayList();
        list.add(0);
        list.add(1);
        statusField.setItems(list);
        statusField.setValue(room.getStatus());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
