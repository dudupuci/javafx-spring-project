package com.app.javafx;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.app.javafx")
public class SpringApplication {
    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }
}
