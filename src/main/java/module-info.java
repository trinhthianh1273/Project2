module com.example.projectjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.projectjava to javafx.fxml;
    opens com.example.entity;
    opens com.example.controller;
    exports com.example.projectjava;
}