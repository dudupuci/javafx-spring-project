package com.app.javafx.controllers;

import com.app.javafx.exceptions.LoginAuthenticationException;
import com.app.javafx.services.impl.UserServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;


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
            try {

            } catch (Exception err) {
                throw new RuntimeException("Error captured: " + err.getMessage());
            }

        } else {
            this.status.setText(AUTHENTICATION_FAILED);
            throw new LoginAuthenticationException("invalid_credentials");
        }

    }

}
