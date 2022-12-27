package com.example.controller;

import com.example.entity.Apartment;
import com.example.model.ApartmentModel;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.glyphfont.FontAwesome;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ApartmentController implements Initializable {
    @FXML
    private TableView<Apartment> apartment_table;

    @FXML
    private TableColumn<?, ?> eidt;

    @FXML
    private TableColumn<?, ?> floor_quanty;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> remove;

    @FXML
    private TableColumn<?, ?> room_quanty;

    @FXML
    private TableColumn<Apartment, Void> Action;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        apartment_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        floor_quanty.setCellValueFactory(new PropertyValueFactory<>("floor_quanty"));
        room_quanty.setCellValueFactory(new PropertyValueFactory<>("room_quanty"));
        insertEditBtn();

        apartment_table.setRowFactory(tableView -> {
            TableRow<Apartment> row = new TableRow<>();
            return row;
        });

        ObservableList<Apartment> list = new ApartmentModel().getAll();
        System.out.println(list);
        apartment_table.setItems(list);
    }

    public void insertEditBtn() {
        TableColumn<Apartment, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Apartment, Void>, TableCell<Apartment, Void>> cellFactory = new javafx.util.Callback<TableColumn<Apartment, Void>, TableCell<Apartment, Void>>() {

            public TableCell<Apartment, Void> call(final TableColumn<Apartment, Void> param) {
                final TableCell<Apartment, Void> cell = new TableCell<Apartment, Void>() {
                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Edit");
                    private final Button RemoveBtn = new Button("Remove");
                    {
                        EditBtn.setOnAction((ActionEvent event) -> {

                            try {
                                TableRow row = this.getTableRow();
                                System.out.println(row.getItem());

//                                ObservableList<Apartment> apartment = apartment_table.getItems();
//                                System.out.println(apartment.get(0));
                                URL url = Paths.get("src/main/resources/com/example/projectjava/ApartmentDetail.fxml").toUri().toURL();
                                Parent parent = FXMLLoader.load(url);

                                Stage stage = new Stage();
                                stage.setScene(new Scene(parent));
                                stage.initStyle(StageStyle.UTILITY);
                                stage.show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    

                    {
                        RemoveBtn.setOnAction((ActionEvent event) -> {
                            Apartment data = getTableView().getItems().get(getIndex());
                            System.out.println("Remove button selected");
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox btnPane = new HBox(EditBtn, RemoveBtn);
                            setGraphic(btnPane);
                        }
                    }
                };
                return cell;
            }
        };

        Action.setCellFactory(cellFactory);

//        apartment_table.getColumns().addAll(colBtn);
    }
}
