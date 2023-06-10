package com.app.javafx.controllers;

import com.app.javafx.alerts.SystemAlerts;
import com.app.javafx.model.entities.Car;
import com.app.javafx.services.impl.CarServiceImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

@Component
public class MainViewController implements Initializable {

    @Value("${system.help.about.message}")
    private String aboutMessage;

    @Value("${system.help.about.header}")
    private String aboutHeader;

    @Value("${system.help.about.title}")
    private String aboutTitle;

    @Autowired
    private CarServiceImpl carService;
    @FXML
    private TableView<Car> carTableView;
    @FXML
    private TableColumn<Car, UUID> tableColumnId;
    @FXML
    private TableColumn<Car, String> tableColumnName;
    @FXML
    private TableColumn<Car, String> tableColumnVehicleType;
    @FXML
    private TableColumn<Car, String> tableColumnVehicleMark;
    @FXML
    private TableColumn<Car, BigDecimal> tableColumnPrice;
    @FXML
    private TableColumn<Car, Long> tableColumnKilometersDriven;
    @FXML
    private TableColumn<Car, Short> tableColumnHorsePower;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private MenuItem aboutMenuItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tableColumnVehicleMark.setCellValueFactory(new PropertyValueFactory<>("vehicleMark"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableColumnKilometersDriven.setCellValueFactory(new PropertyValueFactory<>("kilometersDriven"));
        tableColumnHorsePower.setCellValueFactory(new PropertyValueFactory<>("horsePower"));

        loadCars();

        if (carTableView.getItems().size() == 0) {
            SystemAlerts.showAlertWithDelay(
                    "carts_not_found",
                    null,
                    "Cars not found!",
                    Alert.AlertType.ERROR
            );

        } else {
            SystemAlerts.showAlertWithDelay(
                    "System Initialized",
                    null,
                    "Found cars! Total :" + carTableView.getItems().size(),
                    Alert.AlertType.INFORMATION
            );
        }
    }

    private void loadCars() {
        var carsList = this.carService.findAll();
        carTableView.setItems(FXCollections.observableArrayList(carsList));
    }

    @FXML
    private void onExitMenuItemButtonAction() {
        Platform.exit();
    }

    @FXML
    private void onAboutMenuItemButtonAction() {
        SystemAlerts.showAlertWithoutDelay(
                this.aboutTitle,
                this.aboutHeader,
                this.aboutMessage,
                Alert.AlertType.INFORMATION
        );
    }
}
