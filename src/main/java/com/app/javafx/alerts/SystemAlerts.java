package com.app.javafx.alerts;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.util.Duration;

public class SystemAlerts {

    public static void showAlert(final String title,
                                 final String header,
                                 final String content,
                                 final Alert.AlertType alertType
    ) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);

        PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
        delay.setOnFinished(actionEvent -> Platform.runLater(alert::show));
        delay.play();
    }
}
