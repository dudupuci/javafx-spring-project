package com.app.javafx;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext context;

    @Override
    public void init() throws Exception {
        ApplicationContextInitializer<GenericApplicationContext>
                initializer = applicationContext -> {
                    applicationContext.registerBean(Application.class, () -> JavaFxApplication.this);
                    applicationContext.registerBean(Parameters.class, () -> getParameters());
                    applicationContext.registerBean(HostServices.class, () -> getHostServices());
                };

        this.context = new SpringApplicationBuilder()
                .sources(SpringApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() throws Exception {
        this.context.stop();
        Platform.exit();
    }
}