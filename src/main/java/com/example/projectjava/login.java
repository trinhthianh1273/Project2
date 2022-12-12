package com.example.projectjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class login extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login!");
        stage.setScene(scene);
//        stage.setMaximized(true);
        scene.getStylesheets().add(getClass().getResource("asset/css/login.css").toExternalForm());
        stage.show();
    }
}
