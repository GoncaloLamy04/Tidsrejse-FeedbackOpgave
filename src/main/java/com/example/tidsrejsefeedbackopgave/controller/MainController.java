package com.example.tidsrejsefeedbackopgave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;

public class MainController {

    @FXML
    private StackPane contentArea;

    @FXML
    private void initialize() {
        System.out.println("MainController loaded");
    }

    @FXML
    private void showCustomers() {
        loadView("customers-view.fxml");
    }

    @FXML
    private void showTimeMachines() {
        loadView("time-machines-view.fxml");
    }

    @FXML
    private void showTimePeriods() {
        loadView("time-periods-view.fxml");
    }

    @FXML
    private void showGuides() {
        loadView("guides-view.fxml");
    }

    @FXML
    private void showBooking() {
        loadView("booking-view.fxml");
    }

    private void loadView(String fxml) {
        String path = "/com/example/tidsrejsefeedbackopgave/" + fxml;

        URL resource = getClass().getResource(path);
        if (resource == null) {
            System.err.println("[FXML] Not found: " + path);
            return;
        }

        try {
            Node view = FXMLLoader.load(resource);
            contentArea.getChildren().setAll(view);
        } catch (IOException e) {
            System.err.println("[FXML] Could not load: " + path);
            System.err.println("Reason: " + e.getMessage());
        }
    }
}
