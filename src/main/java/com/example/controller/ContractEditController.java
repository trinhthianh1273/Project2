package com.example.controller;

import com.example.entity.Contract;
import com.example.entity.Renter;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.Date;

public class ContractEditController {

    @FXML
    private TextField TitcheninfraredField;

    @FXML
    private Button addBtn;

    @FXML
    private ComboBox<String> apartmentField;

    @FXML
    private TextField bedField;

    @FXML
    private TextField chairField;

    @FXML
    private TextField deskField;

    @FXML
    private DatePicker endDateField;

    @FXML
    private TextField fridgeField;

    @FXML
    private TextField potField;

    @FXML
    private DatePicker proxy_dob;

    @FXML
    private TextField proxy_name;

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
    private TextField tableField;

    @FXML
    private TextField wardrobeField;

    @FXML
    private TextField RoomName;

    Contract initialContarct = new Contract();

    @FXML
    void update(MouseEvent event) {

    }

    @FXML
    void reset(MouseEvent event) {
        setContract(initialContarct);
    }


    public void setContract(Contract contract) {
        initialContarct = contract;

        apartmentField.setValue(contract.getApartment_name());
        RoomName.setText(contract.getRoom_name());

        Date startDate = new Date(contract.getStartDate().getTime());
        startDateField.setValue(startDate.toLocalDate());

        Date endDate = new Date(contract.getEndDate().getTime());
        endDateField.setValue(endDate.toLocalDate());

        proxy_name.setText(contract.getOwner());
        renter1_name.setText(contract.getRenter1S());
        renter2_name.setText(contract.getRenter2S());
        renter3_name.setText(contract.getRenter3S());
        
        bedField.setText(String.valueOf(contract.getBed()));
        wardrobeField.setText(String.valueOf(contract.getWardrobe()));
        fridgeField.setText(String.valueOf(contract.getFridge()));
        TitcheninfraredField.setText(String.valueOf(contract.getTitchen_infrared()));
        potField.setText(String.valueOf(contract.getPot()));
        deskField.setText(String.valueOf(contract.getDesk()));
        tableField.setText(String.valueOf(contract.getSmall_table()));
        chairField.setText(String.valueOf(contract.getChair()));


    }
}
