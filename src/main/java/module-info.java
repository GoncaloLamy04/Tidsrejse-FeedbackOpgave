module com.example.tidsrejsefeedbackopgave {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tidsrejsefeedbackopgave to javafx.fxml;
    exports com.example.tidsrejsefeedbackopgave;
}