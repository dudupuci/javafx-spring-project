package com.app.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {

    private final String applicationTitle;
    private final Resource fxml;
    private final ApplicationContext applicationContext;

    public StageListener(@Value("${spring.application.ui.title}") String applicationTitle,
                         @Value("classpath:gui/MainView.fxml") Resource fxml,
                         ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.fxml = fxml;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            Stage stage = event.getStage();
            URL url = this.fxml.getURL();
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            ScrollPane scrollPane = fxmlLoader.load();

            scrollPane.setFitToHeight(true); // Adjust height and width of component in view
            scrollPane.setFitToWidth(true);

            scrollPane.setStyle("-fx-border-radius: 20px; -fx-background-color: #e0e0e0;");

            Scene scene = new Scene(scrollPane, 600, 600);
            stage.setScene(scene);
            stage.setTitle(this.applicationTitle);


            stage.initStyle(StageStyle.UNDECORATED);


            stage.show();
        } catch (IOException err) {
            throw new RuntimeException(err);
        }
    }
}
