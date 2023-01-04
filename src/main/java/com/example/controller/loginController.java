package com.example.controller;

import com.example.entity.UserSession;
import com.example.model.UserSessionModel;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Stack;

public class loginController implements Initializable {

    @FXML
    private HBox loginPane;

    @FXML
    private PasswordField password_field;

    @FXML
    private RadioButton remember;

    @FXML
    private Label signin_label;

    @FXML
    private TextField username_field;

    @FXML
    void signin(MouseEvent event) throws IOException {
        UserSession userSession = new UserSessionModel().getOne(username_field.getText(), password_field.getText());

        if (userSession != null) {

            URL url_content = Paths.get("src/main/resources/com/example/projectjava/Main.fxml").toUri().toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url_content);
            Parent parent = loader.load();

            MainController mainController = loader.getController();
            mainController.setUserSession(userSession);

            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setUserData(userSession);
            stage.initStyle(StageStyle.UNIFIED);
            stage.show();

            Stage loginStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            loginStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Status");
            alert.setHeaderText("Login Fail");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
