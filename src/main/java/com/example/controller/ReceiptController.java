package com.example.controller;

import com.example.entity.Receipt;
import com.example.entity.UserSession;
import com.example.model.ApartmentModel;
import com.example.model.ReceiptModel;
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

public class ReceiptController implements Initializable {

    @FXML
    private Text TotalReceipt;

    @FXML
    private TableColumn<Receipt, Void> action;

    @FXML
    private Label add;

    @FXML
    private ComboBox<String> apartmentBox;

    @FXML
    private TableColumn<?, ?> electricFee;

    @FXML
    private RadioButton finished;

    @FXML
    private Text finishedTotal;

    @FXML
    private TableColumn<?, ?> forfeitFee;

    @FXML
    private TableView<Receipt> receipt_table;

    @FXML
    private Label refesh;

    @FXML
    private TableColumn<?, ?> room;

    @FXML
    private ComboBox<String> roomBox;

    @FXML
    private Button search;

    @FXML
    private TableColumn<?, ?> serviceFee;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private TableColumn<?, ?> time;

    @FXML
    private TableColumn<?, ?> totalPayment;

    @FXML
    private RadioButton unfinished;

    @FXML
    private Text unfinishedTotal;

    @FXML
    private TableColumn<?, ?> waterFee;


    private String nameApartmentSelected;
    private String nameRoomSelected;

    @FXML
    void add(MouseEvent event) {

    }

    @FXML
    void refesh(MouseEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

    @FXML
    void show_finished_receipt(MouseEvent event) {

    }

    @FXML
    void show_un_finished_receipt(MouseEvent event) {

    }

    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        room.setCellValueFactory(new PropertyValueFactory<>("room"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        electricFee.setCellValueFactory(new PropertyValueFactory<>("electricFee"));
        waterFee.setCellValueFactory(new PropertyValueFactory<>("waterFee"));
        serviceFee.setCellValueFactory(new PropertyValueFactory<>("service"));
        forfeitFee.setCellValueFactory(new PropertyValueFactory<>("forfeitFee"));
        totalPayment.setCellValueFactory(new PropertyValueFactory<>("total_payment"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        ObservableList<Receipt> list = new ReceiptModel().getAll();
        receipt_table.setItems(list);

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

        insertEditBtn();
    }

    public void insertEditBtn() {
        TableColumn<Receipt, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Receipt, Void>, TableCell<Receipt, Void>> cellFactory = new Callback<TableColumn<Receipt, Void>, TableCell<Receipt, Void>>() {

            @Override
            public TableCell<Receipt, Void> call(TableColumn<Receipt, Void> receiptVoidTableColumn) {
                final TableCell<Receipt, Void> cell = new TableCell<Receipt, Void>() {

                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Edit");
                    private final Button RemoveBtn = new Button("Remove");

                    {
                        EditBtn.setOnAction((ActionEvent event) -> {
                            try {
                                TableRow row = this.getTableRow();
                                System.out.println("Edit clicked");
                                Receipt a = (Receipt) row.getItem();

                                URL url = Paths.get("src/main/resources/com/example/projectjava/ReceiptEditView.fxml").toUri().toURL();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(url);
                                Parent parent = loader.load();

                                ReceiptEditController receiptEditController = loader.getController();
                                receiptEditController.setReceipt(a);

                                Stage stage = new Stage();
                                stage.setScene(new Scene(parent));
                                stage.initStyle(StageStyle.UTILITY);
                                stage.show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });

                        {
                            RemoveBtn.setOnAction((ActionEvent event) -> {
                                Receipt data = getTableView().getItems().get(getIndex());

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Remove Contract Status");

                                boolean deleteStatus = new ReceiptModel().delete(data.getId());

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
                    }

                    @Override
                    protected void updateItem(Void unused, boolean b) {
                        super.updateItem(unused, b);
                        if (b) {
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


}
