package com.example.controller;

import com.example.entity.Renter;
import com.example.model.RenterModel;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class RenterEditController implements Initializable {

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

    private Button updateBtn;
    @FXML
    private ComboBox<?> status;

    public Alert alert;

    Renter initialRenter = new Renter();

    @FXML
    void reset(MouseEvent event) {
        setRenter(initialRenter);
    }

    @FXML
    void update(MouseEvent event) throws ParseException {
        String phoneNew = phone.getText();

        boolean checkPhone = new RenterModel().checkPhone(phoneNew);

        if(!phoneNew.equals(initialRenter.getPhone()) && checkPhone) {
            alert.setHeaderText("Phone Number has already exist");
            alert.showAndWait().ifPresent(buttonType -> {
                if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    //stage.close();
                }
            });
        } else {
            String emailNew = email.getText();
            boolean checkEmail = new RenterModel().checkEmail(emailNew);
            if(!emailNew.equals(initialRenter.getEmail()) && checkEmail) {
                alert.setHeaderText("Email has already exist");
                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        //stage.close();
                    }
                });
            } else {
                String nameNew = name.getText();
                Date dobNew = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(dob.getValue()));

                String gender_text = (String) gender.getValue();
                int genderNew = gender_text == "Female" ? 0 : (gender_text == "Male" ? 1 : -1);

                String provinceNew = province.getText();
                String districtNew = district.getText();
                String communeNew = commune.getText();
                String addressNew = address.getText();


                // String name, String phone, String email, int status, Date dob, String province, String district, String commune, String address, int gender
                Renter renter = new Renter(initialRenter.getId(), nameNew, phoneNew, emailNew, initialRenter.getStatus(), dobNew, provinceNew, districtNew, communeNew, addressNew, genderNew);
                boolean updateStatus = new RenterModel().update(renter);

                if(updateStatus) {
                    alert.setHeaderText("Update Renter Successfully");
                    alert.showAndWait().ifPresent(buttonType -> {
                        if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.close();
                        }
                    });
                } else {
                    alert.setHeaderText("Update Renter Fail");
                    alert.showAndWait().ifPresent(buttonType -> {
                        if (buttonType == ButtonType.OK || buttonType == ButtonType.CANCEL) {
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            //stage.close();
                        }
                    });
                }
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add Room Status");


    }

    public  void setRenter(Renter renter) {
        initialRenter = renter;

        name.setText(renter.getName());

        java.sql.Date sqlDate = new java.sql.Date(renter.getDob().getTime());
        dob.setValue(sqlDate.toLocalDate());

        phone.setText(renter.getPhone());
        email.setText(renter.getEmail());

        ObservableList<String> optionsGender = FXCollections.observableArrayList();
        optionsGender.add("Male");
        optionsGender.add("Female");
        optionsGender.add("Other");
        gender.setItems(optionsGender);
        if(renter.getGender() == 0) {
            gender.setValue("Female");
        } else if(renter.getGender() == 1) {
            gender.setValue("Male");
        } else {
            gender.setValue("Other");
        }

        // tách địa chỉ ra
        String[] str_arr = renter.getAddress().split(",");
        int i = str_arr.length-1;
        if(i >= 0) {
            province.setText(str_arr[i]);
            i--;
        }
        if(i >= 0) {
            district.setText(str_arr[i]);
            i--;
        }
        if(i >= 0) {
            commune.setText(str_arr[i]);
            i--;
        }
        if(i >= 0) {
            address.setText(str_arr[i]);
            i--;
        }

    }
}
