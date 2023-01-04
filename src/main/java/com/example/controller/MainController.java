package com.example.controller;

import com.example.entity.UserSession;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
//            URL url_sidebar = Paths.get("src/main/resources/com/example/projectjava/Main.fxml").toUri().toURL();
//            Parent sidebar = FXMLLoader.load(url_sidebar);

            URL url_content = Paths.get("src/main/resources/com/example/projectjava/DashboardView.fxml").toUri().toURL();
            Parent content = FXMLLoader.load(url_content);

            border_pane.setRight(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private Label apartment;


    @FXML
    private BorderPane border_pane;

    @FXML
    private Label contract;

    @FXML
    private Button contract_link;

    @FXML
    private Label dashboard;

    @FXML
    private Button dashboard_link;
    @FXML
    private Button apartment_link;

    @FXML
    private Label household_good;

    @FXML
    private Button household_good_link;

    @FXML
    private ImageView logo;

    @FXML
    private Label manager;

    @FXML
    private Button manager_link;

    @FXML
    private Label receipt;

    @FXML
    private Button receipt_link;

    @FXML
    private Label renter;

    @FXML
    private Button renter_link;

    @FXML
    private Label room;

    @FXML
    private Button room_link;

    @FXML
    private Label setting;

    @FXML
    private Button setting_link;

    @FXML
    private VBox sidebar;

    @FXML
    private Button signout;

    @FXML
    private Text userSessionName;

    @FXML
    void out(MouseEvent event) {

    }

    void setUserSession(UserSession userSession) {
        userSessionName.setText(userSession.getUserName());
    }

    @FXML
    void show_apartment(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/ApartmentView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);

        border_pane.setRight(content);
        apartment_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }


    @FXML
    void show_contract(MouseEvent event) throws IOException {
        System.out.println("contract");
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/ContractView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        contract_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_dashboard(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/DashboardView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        border_pane.setRight(content);
        dashboard_link.getStyleClass().add("sidebar-btn-active");

        apartment_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_household_good(MouseEvent event) throws IOException {
        System.out.println("apartment view");
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/Household_goodView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        household_good_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");

    }

    @FXML
    void show_manager(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/ManagerView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        manager_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_receipt(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/ReceiptView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        receipt_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_renter(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/RenterView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        renter_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_room(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/RoomView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        room_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        setting_link.getStyleClass().remove("sidebar-btn-active");
    }

    @FXML
    void show_setting(MouseEvent event) throws IOException {
        URL url_content = Paths.get("src/main/resources/com/example/projectjava/SettingView.fxml").toUri().toURL();
        Parent content = FXMLLoader.load(url_content);
        border_pane.setRight(content);

        setting_link.getStyleClass().add("sidebar-btn-active");

        dashboard_link.getStyleClass().remove("sidebar-btn-active");
        room_link.getStyleClass().remove("sidebar-btn-active");
        receipt_link.getStyleClass().remove("sidebar-btn-active");
        renter_link.getStyleClass().remove("sidebar-btn-active");
        contract_link.getStyleClass().remove("sidebar-btn-active");
        household_good_link.getStyleClass().remove("sidebar-btn-active");
        manager_link.getStyleClass().remove("sidebar-btn-active");
        apartment_link.getStyleClass().remove("sidebar-btn-active");
    }


}
