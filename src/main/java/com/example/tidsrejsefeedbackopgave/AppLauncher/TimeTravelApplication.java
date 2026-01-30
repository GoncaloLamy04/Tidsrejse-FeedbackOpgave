package com.example.tidsrejsefeedbackopgave.AppLauncher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimeTravelApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                TimeTravelApplication.class.getResource("/com/example/tidsrejsefeedbackopgave/main-view.fxml")
        );
        Scene scene = new Scene(loader.load(), 900, 600);
        stage.setTitle("Tidsrejseagenturet");
        stage.setScene(scene);
        stage.show();
    }
}
