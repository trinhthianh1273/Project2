package com.example.controller;

import com.example.entity.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Household_goodController implements Initializable {

    @FXML
    private TableColumn<?, ?> action;

    @FXML
    private Text availableItem;

    @FXML
    private TableColumn<?, ?> available_col;

    @FXML
    private Label contract_label1;

    @FXML
    private TableColumn<?, ?> household_name;

    @FXML
    private TableView<?> household_table;

    @FXML
    private Label inuseItem;

    @FXML
    private TableColumn<?, ?> inuse_col;

    @FXML
    private Text totalItem;

    @FXML
    private TableColumn<?, ?> total_col;

    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
