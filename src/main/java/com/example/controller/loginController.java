package com.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class loginController implements Initializable {

    @FXML
    private PasswordField password_field;

    @FXML
    private RadioButton remember;

    @FXML
    private Label signin_label;

    @FXML
    private TextField username_field;

    @FXML
    void signin(MouseEvent event) {
        System.out.println("login");
        System.out.println(username_field.getText());
        System.out.println(password_field.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
