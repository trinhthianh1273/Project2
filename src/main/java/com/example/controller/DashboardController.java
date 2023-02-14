package com.example.controller;

import com.example.entity.UserSession;
import com.example.common.ICommon;
import com.example.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class DashboardController implements Initializable {

    @FXML
    private Text Expirred;

    @FXML
    private Text Renting;

    @FXML
    private Text TotalBuilding;

    @FXML
    private Text TotalContract;

    @FXML
    private Text TotalReceipt;

    @FXML
    private Text TotalRoom;

    @FXML
    private Text TotalTenant;

    @FXML
    private Text finishedTotal;

    @FXML
    private Text rentered;

    @FXML
    private Text rentering;

    @FXML
    private Text totalRenter;

    @FXML
    private Text unfinishedTotal;

    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(this.userSession);

        ApartmentModel ApartmentModel = new ApartmentModel();
        int countApartment = ApartmentModel.getTotalApartment();
        TotalBuilding.setText(String.valueOf(countApartment));

        RoomModel roomModel = new RoomModel();
        int countRoom = roomModel.getTotalRoom();
        TotalRoom.setText(String.valueOf(countRoom));

        RenterModel RenterModel = new RenterModel();
        int countRenter = RenterModel.getTotalRenter();
        int ingCount = RenterModel.getTotalRenterIng();
        int edCount = RenterModel.getTotalRenterEd();
        TotalTenant.setText(String.valueOf(countRenter));
        // set for renter
        totalRenter.setText(String.valueOf(countRenter));
        rentering.setText(String.valueOf(ingCount));
        rentered.setText(String.valueOf(edCount));

        ContractModel contractModel = new ContractModel();
        int totalContract = contractModel.getAll().size();
        AtomicInteger contractRenting = contractModel.getContractRenting();
        AtomicInteger contractExpirred = contractModel.getContractExpirred();
        // set for contract
        TotalContract.setText(String.valueOf(totalContract));
        Renting.setText(String.valueOf(contractRenting));
        Expirred.setText(String.valueOf(contractExpirred));

        ReceiptModel receiptModel = new ReceiptModel();
        int totalReceipt = receiptModel.getTotalReceipt();
        AtomicInteger finishedReceipt = receiptModel.getFinishedReceipt();
        AtomicInteger uhfinishedReceipt = receiptModel.getunFinishedReceipt();
        // set for receipt
        TotalReceipt.setText(String.valueOf(totalReceipt));
        finishedTotal.setText(String.valueOf(finishedReceipt));
        unfinishedTotal.setText(String.valueOf(uhfinishedReceipt));

    }
}
