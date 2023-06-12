package com.app.javafx.controllers;

import com.app.javafx.exceptions.LoginAuthenticationException;
import com.app.javafx.repositories.CarRepository;
import com.app.javafx.services.CarService;
import com.app.javafx.services.OperatorService;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;


@Component
public class LoginViewController implements Initializable {
    private static final String AUTHENTICATION_SUCCESS = "Authentication success!";
    private static final String AUTHENTICATION_FAILED = "Authentication failed!";
    @Autowired
    private final CarService carService;
    @Autowired
    private final OperatorService operatorService;
    @Autowired
    private final CarRepository repository;

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label status;
    @FXML
    private Button accessButton;

    public LoginViewController(CarService carService, OperatorService operatorService, CarRepository repository) {
        this.carService = carService;
        this.operatorService = operatorService;
        this.repository = repository;
    }

    @FXML
    private void onAccessButtonAction() {
        var loginRequestOperator = this.operatorService.findByEmailAndPassword(
                emailTextField.getText(),
                passwordTextField.getText()
        );

        if (loginRequestOperator != null) {
            this.status.setText(AUTHENTICATION_SUCCESS);
            PauseTransition pauseTransition = new PauseTransition(Duration.seconds(3));
            pauseTransition.setOnFinished(event -> {
                try {
                    loadView("/gui/MainView.fxml", (MainViewController controller) -> {
                        controller.setMainViewController(this.carService);
                    });
                } catch (Exception err) {
                    throw new RuntimeException("Error captured: " + err.getMessage());
                }
            });
            pauseTransition.play();
        } else {
            this.status.setText(AUTHENTICATION_FAILED);
            throw new LoginAuthenticationException("invalid_credentials");
        }
    }

    private synchronized <T> void loadView(final String absoluteName, Consumer<T> initializingAction) throws InterruptedException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            ScrollPane scrollPane = loader.load();

            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);

            Scene mainScene = new Scene(scrollPane);
            Stage primaryStage = (Stage) accessButton.getScene().getWindow();
            Stage newStage = new Stage();
            newStage.setScene(mainScene);

            newStage.setTitle("Application");

            // Feche a janela de login
            primaryStage.close();

            // Mostre a nova janela
            newStage.show();

        } catch (IOException e) {
            throw new RuntimeException("err" + e.getMessage());
            //SystemAlerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
