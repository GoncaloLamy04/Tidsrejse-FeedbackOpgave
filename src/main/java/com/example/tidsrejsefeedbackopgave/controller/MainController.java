package com.example.tidsrejsefeedbackopgave.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

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
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/example/tidsrejsefeedbackopgave/" + fxml)
            );
            Node view = loader.load();
            root.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
