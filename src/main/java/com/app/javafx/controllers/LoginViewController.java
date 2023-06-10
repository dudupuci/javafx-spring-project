package com.app.javafx.controllers;

import com.app.javafx.services.impl.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginViewController {

    @Autowired
    private UserServiceImpl userService;
    private static final String AUTHENTICATION_SUCCESS = "Authentication success!";
    private static final String AUTHENTICATION_FAILED = "Authentication failed!";

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label status;
    @FXML
    private Button accessButton;

    @FXML
    private void onAccessButtonAction() {
        var loginRequestOperator = this.userService.findByEmailAndPassword(
                emailTextField.getText(),
                passwordTextField.getText()
        );


        if (loginRequestOperator != null) {
            this.status.setText(AUTHENTICATION_SUCCESS);
        } else {
            this.status.setText(AUTHENTICATION_FAILED);
        }

    }
}
