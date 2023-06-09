package com.app.javafx;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

class StageReadyEvent extends ApplicationEvent {

    public Stage getStage() {
        return Stage.class.cast(getSource());
    }
    public StageReadyEvent(Stage source) {
        super(source);
    }
}
