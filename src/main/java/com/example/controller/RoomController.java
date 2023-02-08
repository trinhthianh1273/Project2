package com.example.controller;

import com.example.entity.Apartment;
import com.example.entity.Contract;
import com.example.entity.Room;
import com.example.entity.UserSession;
import com.example.model.ApartmentModel;
import com.example.model.ContractModel;
import com.example.model.RoomModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class RoomController implements Initializable {
    ObservableList<Room> ListRoom = new RoomModel().getAll();
    @FXML
    private TableColumn<Room, Void> action;

    @FXML
    private TableColumn<?, ?> actualPeople;

    @FXML
    private Label add;

    @FXML
    private ComboBox<String> apartmentBox;

    @FXML
    private TableColumn<?, ?> apartment_name;

    @FXML
    private Label contract_label;

    @FXML
    private RadioButton empty_box;

    @FXML
    private Text emptyroom;

    @FXML
    private TableColumn<?, ?> memberMax;

    @FXML
    private Label refesh;

    @FXML
    private TableColumn<?, ?> rental;

    @FXML
    private RadioButton rented_box;

    @FXML
    private Text rentedroom;

    @FXML
    private TableColumn<?, ?> room_id;

    @FXML
    private TableColumn<?, ?> room_name;

    @FXML
    private TableView<Room> room_table;

    @FXML
    private Button search;

    @FXML
    private TableColumn<?, ?> status;

    @FXML
    void add(MouseEvent event) throws IOException {
        System.out.println(userSession);
        URL url = Paths.get("src/main/resources/com/example/projectjava/RoomAddView.fxml").toUri().toURL();
        Parent parent = FXMLLoader.load(url);

        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    @FXML
    void refesh(MouseEvent event) {
        rented_box.setSelected(false);
        empty_box.setSelected(false);
        ObservableList<Room> list = new RoomModel().getAll();
        room_table.getItems().setAll(list);
    }

    @FXML
    void search(MouseEvent event) {
        System.out.println("Search button clicked");
        System.out.println(nameApartmentSelected);
        if (nameApartmentSelected != null) {
            ObservableList<Room> list = new RoomModel().getAllByApartmentName(nameApartmentSelected);
            room_table.setItems(list);
        }
    }

    @FXML
    void show_empty_room(MouseEvent event) {
        ObservableList<Room> list = new RoomModel().getEmptyRoom();
        room_table.setItems(list);
    }

    @FXML
    void show_rented_room(MouseEvent event) {
        ObservableList<Room> list = new RoomModel().getRentedRoom();
        room_table.setItems(list);
    }

    private String nameApartmentSelected;
    private UserSession userSession;
    void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoomModel roomModel = new RoomModel();

        // lấy list room
        ObservableList<Room> list = roomModel.getAll();
        System.out.println(list);

        AtomicInteger countRentedRoom = new AtomicInteger();
        AtomicInteger countEmptyRoom = new AtomicInteger();
        list.forEach(i -> {
            if(i.getStatus() == 1) {
                countRentedRoom.getAndIncrement();
            } else {
                countEmptyRoom.getAndIncrement();
            }
        });

        rentedroom.setText(String.valueOf(countRentedRoom));
        emptyroom.setText(String.valueOf(countEmptyRoom));

        // thêm 2 radio checkbox
        ToggleGroup tg = new ToggleGroup();
        rented_box.setToggleGroup(tg);
        empty_box.setToggleGroup(tg);

        // lấy list tên apartment
        ObservableList<String> optionsName = new ApartmentModel().getApartmentName();
        apartmentBox.setPromptText("Search Apartment");
        apartmentBox.setItems(optionsName);

        apartmentBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                nameApartmentSelected = apartmentBox.getValue();
            }
        });

        room_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        apartment_name.setCellValueFactory(new PropertyValueFactory<>("apartment_name"));
        room_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        rental.setCellValueFactory(new PropertyValueFactory<>("rental"));
        memberMax.setCellValueFactory(new PropertyValueFactory<>("member_max"));
        actualPeople.setCellValueFactory(new PropertyValueFactory<>("actual_people"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        room_table.setItems(list);

        insertEditBtn();

    }

    public void insertEditBtn() {
        TableColumn<Room, Void> colBtn = new TableColumn("Action");

        javafx.util.Callback<TableColumn<Room, Void>, TableCell<Room, Void>> cellFactory = new Callback<TableColumn<Room, Void>, TableCell<Room, Void>>() {

            public TableCell<Room, Void> call(final TableColumn<Room, Void> param) {
                final TableCell<Room, Void> cell = new TableCell<Room, Void>() {
                    FontAwesome editIcon = new FontAwesome();

                    private final Button EditBtn = new Button("Edit");
                    private final Button RemoveBtn = new Button("Remove");
                    {
                        EditBtn.setOnAction((ActionEvent event) -> {

                            try {
                                TableRow row = this.getTableRow();
                                System.out.println("Edit clicked");
                                Room a = (Room) row.getItem();
                                System.out.println(a);

//                                ObservableList<Apartment> apartment = apartment_table.getItems();
//                                System.out.println(apartment.get(0));
                                URL url = Paths.get("src/main/resources/com/example/projectjava/RoomDetail.fxml").toUri().toURL();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(url);
                                Parent parent = loader.load();

                                RoomDetailController roomDetailController = loader.getController();
                                roomDetailController.setRoom(a);

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
                            Room data = getTableView().getItems().get(getIndex());
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
        action.setCellFactory(cellFactory);
    }
}
