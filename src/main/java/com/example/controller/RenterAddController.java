package com.example.controller;

import com.example.entity.Renter;
import com.example.model.ApartmentModel;
import com.example.model.RenterModel;
import com.example.model.RoomModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

public class RenterAddController implements Initializable {

        @FXML
        private HBox NewRenterEmail;

        @FXML
        private HBox NewRenterPhone;

        @FXML
        private Button addBtn;

        @FXML
        private TextField address;

        @FXML
        private TextField commune;

        @FXML
        private TextField district;

        @FXML
        private DatePicker dob;

        @FXML
        private TextField email;

        @FXML
        private ComboBox<String> gender;

        @FXML
        private TextField name;

        @FXML
        private TextField phone;

        @FXML
        private TextField province;

        @FXML
        private Button resetBtn;

        @FXML
        void add(MouseEvent event) throws ParseException {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Add Renter Status");

                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(dob.getValue()));
                System.out.println(date);

                int renter_status = 0;
                String renter_name = name.getText();
                Date renter_dob = date;
                String renter_phone = phone.getText();
                String renter_email = email.getText();

                String gender_text = (String) gender.getValue();
                int renter_gender = gender_text == "Female" ? 0 : (gender_text == "Male" ? 1 : -1);
                String renter_province = province.getText();
                String renter_district = district.getText();
                String renter_commune = commune.getText();
                String renter_address = address.getText();

                // String name, String phone, String email, int status, Date dob, String province, String district, String commune, String address, int gender
                Renter renter = new Renter(renter_name, renter_phone, renter_email, renter_status, renter_dob, renter_province, renter_district, renter_commune, renter_address, renter_gender);

                System.out.println(renter);


                boolean checkEmail = new RenterModel().checkEmail(renter_email);
                boolean checkPhone = new RenterModel().checkPhone(renter_phone);

                if(checkEmail) {
                        alert.setHeaderText("Email has already exist");
                        alert.showAndWait().ifPresent(buttonType -> {
                                if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                        //stage.close();
                                }
                        });
                } else if(checkPhone) {
                        alert.setHeaderText("Phone Number has already exist");
                        alert.showAndWait().ifPresent(buttonType -> {
                                if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                        //stage.close();
                                }
                        });
                } else {
                        boolean addStatus = new RenterModel().add(renter);

                        if (!addStatus) {
                                alert.setHeaderText("Add New Renter Fail");
                                alert.showAndWait().ifPresent(buttonType -> {
                                        if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                                //stage.close();
                                        }
                                });
                        } else {
                                alert.setHeaderText("Add New Renter Successfully");
                                alert.showAndWait().ifPresent(buttonType -> {
                                        if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                                stage.close();
                                        }
                                });
                        }
                }
        }

        @FXML
        void reset(MouseEvent event) {
                name.setText("");
                dob.setValue(null);
                phone.setText("");
                email.setText("");
                gender.setValue(null);
                province.setText("");
                district.setText("");
                commune.setText("");
                address.setText("");
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                ObservableList<String> optionsGender = FXCollections.observableArrayList();
                optionsGender.add("Male");
                optionsGender.add("Female");
                optionsGender.add("Other");
                gender.setItems(optionsGender);

                gender.setPromptText("Choose gender");

                /*
                Pattern phonePatter = Pattern.compile("(84|0[3|5|7|8|9])+([0-9]{8})\\b");
                TextFormatter<?> PhoneFormatter = new TextFormatter<>(change -> {
                   if(phonePatter.matcher(change.getControlNewText()).matches()) {
                           return change;
                   } else {
                           return null;
                   }
                });
                phone.setTextFormatter(PhoneFormatter);
                 */
        }
}


