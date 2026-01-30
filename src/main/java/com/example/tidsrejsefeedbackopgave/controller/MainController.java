package com.example.tidsrejsefeedbackopgave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class MainController {

    @FXML
    private BorderPane root;

    @FXML
    private void initialize() {
        System.out.println("MainController loaded");
    }

    @FXML
    private void showCustomers() {
        setCenter("customers-view.fxml");
    }

    @FXML
    private void showTimeMachines() {
        setCenter("time-machines-view.fxml");
    }

    @FXML
    private void showTimePeriods() {
        setCenter("time-periods-view.fxml");
    }

    @FXML
    private void showGuides() {
        setCenter("guides-view.fxml");
    }

    @FXML
    private void showBooking() {
        setCenter("booking-view.fxml");
    }

    private void setCenter(String fxml) {
        String path = "/com/example/tidsrejsefeedbackopgave/" + fxml;

        URL resource = getClass().getResource(path);
        if (resource == null) {
            System.err.println("[FXML] Not found: " + path);
            return;
        }

        try {
            Node view = FXMLLoader.load(resource);
            root.setCenter(view);
        } catch (IOException e) {
            System.err.println("[FXML] Could not load: " + path);
            System.err.println("Reason: " + e.getMessage());
        }
    }
}
