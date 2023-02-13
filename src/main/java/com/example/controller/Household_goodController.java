package com.example.controller;

import com.example.entity.*;
import com.example.model.ContractModel;
import com.example.model.Household_goodModel;
import com.example.model.RenterModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.controlsfx.glyphfont.FontAwesome;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Household_goodController implements Initializable {

    @FXML
    private TableColumn<Household_good, Void> action;

    @FXML
    private Text availableItem;

    @FXML
    private TableColumn<?, ?> available_col;

    @FXML
    private Label contract_label1;

    @FXML
    private TableColumn<?, ?> household_name;

    @FXML
    private TableView<Household_good> household_table;

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

        ObservableList<Household_good> list = new Household_goodModel().getAll();
        System.out.println(list);

        household_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        total_col.setCellValueFactory(new PropertyValueFactory<>("quanty"));
        inuse_col.setCellValueFactory(new PropertyValueFactory<>("in_used"));
        available_col.setCellValueFactory(new PropertyValueFactory<>("not_used"));

        household_table.setItems(list);

        insertBtn();
    }

    public void insertBtn() {
        TableColumn<Household_good, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Household_good, Void>, TableCell<Household_good, Void>> cellFactory = new Callback<TableColumn<Household_good, Void>, TableCell<Household_good, Void>>() {

            @Override
            public TableCell<Household_good, Void> call(TableColumn<Household_good, Void> contractVoidTableColumn) {
                final TableCell<Household_good, Void> cell = new TableCell<Household_good, Void>() {
                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Detail");
                    private final Button RemoveBtn = new Button("Remove");
                    {
                        EditBtn.setOnAction((ActionEvent event) -> {

                            try {
                                TableRow row = this.getTableRow();
                                System.out.println("Edit clicked");
                                Household_good a = (Household_good) row.getItem();

                                URL url = Paths.get("src/main/resources/com/example/projectjava/ContractEditView.fxml").toUri().toURL();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(url);
                                Parent parent = loader.load();

                                Household_goodDetailController household_goodDetailController = loader.getController();
                                household_goodDetailController.setHousehold_good(a);

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
                            Household_good data = getTableView().getItems().get(getIndex());

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Remove Contract Status");

                            boolean deleteStatus = new ContractModel().delete(data.getId());

                            if(deleteStatus) {
                                alert.setHeaderText("Delete contract successfully");
                                alert.showAndWait().ifPresent(buttonType -> {
                                    if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                        //stage.close();
                                    }
                                });
                            } else {
                                alert.setHeaderText("Delete contract fail");
                                alert.showAndWait().ifPresent(buttonType -> {
                                    if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                        //stage.close();
                                    }
                                });
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            HBox btnPane = new HBox(EditBtn);
                            setGraphic(btnPane);
                        }
                    }
                };
                return cell;
            }
        };
        action.setCellFactory(cellFactory);
    }
}
