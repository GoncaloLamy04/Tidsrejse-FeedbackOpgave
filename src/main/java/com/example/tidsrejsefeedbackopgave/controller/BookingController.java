package com.example.tidsrejsefeedbackopgave.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BookingController {

    @FXML private ComboBox<String> customerComboBox;
    @FXML private ComboBox<String> guideComboBox;
    @FXML private ComboBox<String> timePeriodComboBox;
    @FXML private ComboBox<String> timeMachineComboBox;
    @FXML private Button createBookingButton;

    private final ObservableList<String> customers = FXCollections.observableArrayList();
    private final ObservableList<String> guides = FXCollections.observableArrayList();
    private final ObservableList<String> timePeriods = FXCollections.observableArrayList();
    private final ObservableList<String> timeMachines = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // bind lister til UI
        customerComboBox.setItems(customers);
        guideComboBox.setItems(guides);
        timePeriodComboBox.setItems(timePeriods);
        timeMachineComboBox.setItems(timeMachines);

        // prompt text (så den ikke ser "tom" ud)
        customerComboBox.setPromptText("Vælg kunde");
        guideComboBox.setPromptText("Vælg guide");
        timePeriodComboBox.setPromptText("Vælg tidsperiode");
        timeMachineComboBox.setPromptText("Vælg tidsmaskine");

        // dummy data (com.example.tidsrejsefeedbackopgave.DB kommer senere)
        customers.addAll("1 - Nicki (nicki@mail.dk)", "2 - Goncalo (gon@mail.dk)");
        guides.addAll("Professor Quantum (Historisk ekspert)", "Dr. Paradox (Futuristisk navigation)");
        timePeriods.addAll("Dinosaurernes æra", "Middelalderen", "Fremtiden");
        timeMachines.addAll("T-1000 (kap: 4, ledig)", "ChronoJet (kap: 2, i brug)");

        // disable knappen indtil alle 4 valg er sat
        Runnable updateButtonState = () -> createBookingButton.setDisable(
                customerComboBox.getValue() == null ||
                        guideComboBox.getValue() == null ||
                        timePeriodComboBox.getValue() == null ||
                        timeMachineComboBox.getValue() == null
        );

        customerComboBox.valueProperty().addListener((obs, oldV, newV) -> updateButtonState.run());
        guideComboBox.valueProperty().addListener((obs, oldV, newV) -> updateButtonState.run());
        timePeriodComboBox.valueProperty().addListener((obs, oldV, newV) -> updateButtonState.run());
        timeMachineComboBox.valueProperty().addListener((obs, oldV, newV) -> updateButtonState.run());

        // initial state
        updateButtonState.run();
    }

    @FXML
    private void onCreateBooking() {
        String customer = customerComboBox.getValue();
        String guide = guideComboBox.getValue();
        String period = timePeriodComboBox.getValue();
        String machine = timeMachineComboBox.getValue();

        // ekstra sikkerhed (fx hvis nogen kalder handleren udenom disable)
        if (customer == null || guide == null || period == null || machine == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Manglende valg");
            alert.setHeaderText("Du mangler at vælge noget");
            alert.setContentText("Vælg kunde, guide, tidsperiode og tidsmaskine før du opretter booking.");
            alert.showAndWait();
            return;
        }

        System.out.println("Booking:");
        System.out.println("  Kunde: " + customer);
        System.out.println("  Guide: " + guide);
        System.out.println("  Tidsperiode: " + period);
        System.out.println("  Tidsmaskine: " + machine);

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setTitle("Booking oprettet");
        ok.setHeaderText("Booking oprettet (dummy)");
        ok.setContentText(
                "Kunde: " + customer + "\n" +
                        "Guide: " + guide + "\n" +
                        "Tidsperiode: " + period + "\n" +
                        "Tidsmaskine: " + machine
        );
        ok.showAndWait();
    }
}
