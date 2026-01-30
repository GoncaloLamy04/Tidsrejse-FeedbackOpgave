module com.example.tidsrejsefeedbackopgave {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.tidsrejsefeedbackopgave to javafx.fxml;
    exports com.example.tidsrejsefeedbackopgave.AppLauncher;
    opens com.example.tidsrejsefeedbackopgave.AppLauncher to javafx.fxml;
    opens com.example.tidsrejsefeedbackopgave.controller to javafx.fxml;
}