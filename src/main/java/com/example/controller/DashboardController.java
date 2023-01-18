package com.example.controller;

import com.example.entity.UserSession;
import com.example.common.ICommon;
import com.example.model.ApartmentModel;
import com.example.model.RenterModel;
import com.example.model.RoomModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private Text TotalBuilding;

    @FXML
    private Text TotalRoom;

    @FXML
    private Text TotalTenant;

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
        TotalTenant.setText(String.valueOf(countRenter));

        System.out.println(countApartment);

    }
}
