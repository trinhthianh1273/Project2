package com.example.controller;

import com.example.entity.Renter;
import com.example.entity.Room;
import com.example.entity.UserSession;
import com.example.model.RenterModel;
import com.example.model.RoomModel;
import javafx.collections.FXCollections;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class RenterController implements Initializable {

    @FXML
    private TableColumn<Renter, Void> action;

    @FXML
    private TableColumn<?, ?> actualPeople;

    @FXML
    private Label add;

    @FXML
    private TableColumn<?, ?> apartment_name;

    @FXML
    private Label contract_label;

    @FXML
    private RadioButton ed_box;

    @FXML
    private RadioButton ing_box;

    @FXML
    private TableColumn<?, ?> memberMax;

    @FXML
    private Label refesh;

    @FXML
    private TableColumn<?, ?> rental;

    @FXML
    private TableView<Renter> renter_table;

    @FXML
    private Text rentered;

    @FXML
    private Text rentering;

    @FXML
    private TableColumn<?, ?> room_id;

    @FXML
    private TableColumn<?, ?> room_name;

    @FXML
    private Button search;

    @FXML
    private TextField search_box;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    private Text totalRenter;

    @FXML
    private RadioButton will_move_box;

    @FXML
    private TableColumn<?, ?> tenant_address;

    @FXML
    private TableColumn<?, ?> tenant_dob;

    @FXML
    private TableColumn<?, ?> tenant_email;

    @FXML
    private TableColumn<?, ?> tenant_gender;

    @FXML
    private TableColumn<?, ?> tenant_id;

    @FXML
    private TableColumn<?, ?> tenant_name;

    @FXML
    private TableColumn<?, ?> tenant_phone;

    @FXML
    private TableColumn<?, ?> tenant_status;

    @FXML
    void add(MouseEvent event) throws IOException {
        System.out.println(userSession);
        URL url = Paths.get("src/main/resources/com/example/projectjava/RenterAddView.fxml").toUri().toURL();

        Parent parent = FXMLLoader.load(url);

        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void refesh(MouseEvent event) {
        ing_box.setSelected(false);
        will_move_box.setSelected(false);
        ed_box.setSelected(false);
        ObservableList<Renter> list_all = new RenterModel().getAll();
        renter_table.setItems(list_all);
    }

    @FXML
    void search(MouseEvent event) {
        String search_str = search_box.getText();

        ObservableList<Renter> list = FXCollections.observableArrayList();
        ObservableList<Renter> list_all = new RenterModel().getAll();

        list_all.forEach(renter -> {
            if(renter.getAddress().contains(search_str) || renter.getName().contains(search_str) || renter.getPhone().contains(search_str) || renter.getEmail().contains(search_str)) {
                //System.out.println(search_str);
                list.add(renter);
            }
        });

        renter_table.setItems(list);

    }

    @FXML
    void show_renter_ed(MouseEvent event) {
        System.out.println("show renter ed");

        ObservableList<Renter> list_renter_ed = FXCollections.observableArrayList();
        ObservableList<Renter> list_all = new RenterModel().getAll();

        list_all.forEach(renter -> {
            if(renter.getStatus() == 0) {
                list_renter_ed.add(renter);
            }
        });

        System.out.println(list_renter_ed);
        renter_table.setItems(list_renter_ed);
    }

    @FXML
    void show_renter_ing(MouseEvent event) {
        System.out.println("show renter ing");

        ObservableList<Renter> list_renter_ing = FXCollections.observableArrayList();
        ObservableList<Renter> list_all = new RenterModel().getAll();

        list_all.forEach(renter -> {
            if(renter.getStatus() != 0) {
                list_renter_ing.add(renter);
            }
        });

        System.out.println(list_renter_ing);
        renter_table.setItems(list_renter_ing);
    }

    @FXML
    void show_renter_will_end(MouseEvent event) {
        System.out.println("search renter will end");

        ObservableList<Renter> list_renter_will_end = FXCollections.observableArrayList();
        ObservableList<Renter> list_all = new RenterModel().getAll();

        list_all.forEach(renter -> {
            if(renter.getStatus() == -1) {
                list_renter_will_end.add(renter);
            }
        });

        System.out.println(list_renter_will_end);
        renter_table.setItems(list_renter_will_end);
    }


    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RenterModel renterModel = new RenterModel();

        ToggleGroup tg = new ToggleGroup();
        ing_box.setToggleGroup(tg);
        will_move_box.setToggleGroup(tg);
        ed_box.setToggleGroup(tg);

        totalRenter.setText(String.valueOf(renterModel.getTotalRenter()));
        rentering.setText(String.valueOf(renterModel.getTotalRenterIng()));
        rentered.setText(String.valueOf(renterModel.getTotalRenterEd()));

        ObservableList<Renter> list = renterModel.getAll();
        tenant_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tenant_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tenant_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        tenant_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tenant_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tenant_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tenant_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tenant_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        renter_table.setItems(list);

        insertEditBtn();

    }

    public void insertEditBtn() {
        TableColumn<Renter, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Renter, Void>, TableCell<Renter, Void>> cellFactory = new Callback<TableColumn<Renter, Void>, TableCell<Renter, Void>>() {

            @Override
            public TableCell<Renter, Void> call(TableColumn<Renter, Void> renterVoidTableColumn) {
                final TableCell<Renter, Void> cell = new TableCell<Renter, Void>() {
                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Edit");
                    private final Button RemoveBtn = new Button("Remove");
                    {
                        EditBtn.setOnAction((ActionEvent event) -> {

                            try {
                                TableRow row = this.getTableRow();
                                System.out.println("Edit clicked");
                                Renter a = (Renter) row.getItem();

                                URL url = Paths.get("src/main/resources/com/example/projectjava/RenterEditView.fxml").toUri().toURL();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(url);
                                Parent parent = loader.load();

                                RenterEditController renterEditController = loader.getController();
                                renterEditController.setRenter(a);

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
                            Renter data = getTableView().getItems().get(getIndex());

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Remove Renter Status");

                            if(data.getStatus() == 1) {
                                alert.setHeaderText("This renter is in contract");
                                alert.showAndWait().ifPresent(buttonType -> {
                                    if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                        //stage.close();
                                    }
                                });
                            } else {
                                boolean removeRenter = new RenterModel().delete(data.getId());
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

}