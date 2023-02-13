package com.example.controller;

import com.example.entity.Contract;
import com.example.entity.UserSession;
import com.example.model.ApartmentModel;
import com.example.model.ContractModel;
import com.example.model.RenterModel;
import com.example.model.RoomModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.controlsfx.glyphfont.FontAwesome;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ContractController implements Initializable {

    @FXML
    private Text Expirred;

    @FXML
    private Text Renting;

    @FXML
    private Text TotalContract;

    @FXML
    private TableColumn<Contract, Void> action;

    @FXML
    private Label add;

    @FXML
    private ComboBox<String> apartmentBox;

    @FXML
    private TableColumn<?, ?> apartment_name;

    @FXML
    private TableColumn<?, ?> contract_id;

    @FXML
    private Label contract_label;

    @FXML
    private TableView<Contract> contract_table;

    @FXML
    private TableColumn<?, ?> endDate;

    @FXML
    private TableColumn<?, ?> owner;

    @FXML
    private Label refesh;

    @FXML
    private ComboBox<String> roomBox;

    @FXML
    private TableColumn<?, ?> room_name;

    @FXML
    private Button search;

    @FXML
    private TableColumn<?, ?> startDate;

    @FXML
    private TableColumn<?, ?> status;

    private String nameApartmentSelected;
    private String nameRoomSelected;

    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contract_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        apartment_name.setCellValueFactory(new PropertyValueFactory<>("apartment_name"));
        room_name.setCellValueFactory(new PropertyValueFactory<>("room_name"));
        owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Contract> list = new ContractModel().getAllBrief();
        //System.out.println(list);
        contract_table.setItems(list);

        ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        apartmentBox.setPromptText("Search Apartment");
        apartmentBox.setItems(optionsName);
        apartmentBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                nameApartmentSelected = apartmentBox.getValue();
                ObservableList<String> roomName = new RoomModel().getRoomNameByApartment(nameApartmentSelected);

                roomBox.setItems(roomName);
                System.out.println(roomName);
            }
        });

        roomBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                nameRoomSelected = roomBox.getValue();
            }
        });

        roomBox.setPromptText("Search Room");

        TotalContract.setText(String.valueOf(list.size()));

        AtomicInteger rentingCount = new AtomicInteger();
        AtomicInteger expirredCount = new AtomicInteger();

        list.forEach(item -> {
            if(item.getStatus() == 0) {
                expirredCount.getAndIncrement();
            } else if(item.getStatus() == 1) {
                rentingCount.getAndIncrement();
            }
        });

        Renting.setText(String.valueOf(rentingCount));
        Expirred.setText(String.valueOf(expirredCount));

        insertEditBtn();
    }

    public void insertEditBtn() {
        TableColumn<Contract, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Contract, Void>, TableCell<Contract, Void>> cellFactory = new Callback<TableColumn<Contract, Void>, TableCell<Contract, Void>>() {

            @Override
            public TableCell<Contract, Void> call(TableColumn<Contract, Void> contractVoidTableColumn) {
                final TableCell<Contract, Void> cell = new TableCell<Contract, Void>() {
                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Edit");
                    private final Button RemoveBtn = new Button("Remove");
                    {
                        EditBtn.setOnAction((ActionEvent event) -> {

                            try {
                                TableRow row = this.getTableRow();
                                System.out.println("Edit clicked");
                                Contract a = (Contract) row.getItem();

                                URL url = Paths.get("src/main/resources/com/example/projectjava/ContractEditView.fxml").toUri().toURL();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(url);
                                Parent parent = loader.load();

                                ContractEditController contractEditController = loader.getController();
                                contractEditController.setContract(a);

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
                            Contract data = getTableView().getItems().get(getIndex());

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
                            HBox btnPane = new HBox(EditBtn, RemoveBtn);
                            setGraphic(btnPane);
                        }
                    }
                };
                return cell;
            }
        };
        action.setCellFactory(cellFactory);
    }


    @FXML
    void add(MouseEvent event) throws IOException {
        System.out.println(userSession);
        URL url = Paths.get("src/main/resources/com/example/projectjava/ContractAddView.fxml").toUri().toURL();
        Parent parent = FXMLLoader.load(url);

        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void refesh(MouseEvent event) {
        ObservableList<Contract> list = new ContractModel().getAll();
        contract_table.getItems().setAll(list);
    }

    @FXML
    void search(MouseEvent event) {
        System.out.println(nameApartmentSelected);
        System.out.println(nameRoomSelected);
        if (nameApartmentSelected != null) {
            if(nameRoomSelected != null) {
                ObservableList<Contract> list = new ContractModel().getAllBriefByApartmentAndRoom(nameApartmentSelected, nameRoomSelected);
                contract_table.setItems(list);
            } else {
                ObservableList<Contract> list = new ContractModel().getAllBriefByApartment(nameApartmentSelected);
                contract_table.setItems(list);
            }
        }
    }
}
