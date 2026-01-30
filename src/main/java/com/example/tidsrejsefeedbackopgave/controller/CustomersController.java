package com.example.tidsrejsefeedbackopgave.controller;

import com.example.tidsrejsefeedbackopgave.DAO.CustomerDAO;
import com.example.tidsrejsefeedbackopgave.Model.Customer;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CustomersController {

    // UI
    @FXML private TextField nameField;
    @FXML private TextField emailField;

    @FXML private Button createButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button clearButton;

    @FXML private TableView<Customer> customersTable;
    @FXML private TableColumn<Customer, Integer> idColumn;
    @FXML private TableColumn<Customer, String> nameColumn;
    @FXML private TableColumn<Customer, String> emailColumn;

    private final ObservableList<Customer> customers = FXCollections.observableArrayList();
    private final CustomerDAO dao = new CustomerDAO();

    @FXML
    private void initialize() {
        // IMPORTANT: Lambdas = ingen module/reflection problemer
        idColumn.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getId()));
        nameColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getName()));
        emailColumn.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getEmail()));

        customersTable.setItems(customers);

        customers.setAll(dao.readAll());

        updateButton.setDisable(true);
        deleteButton.setDisable(true);

        customersTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, sel) -> {
            boolean hasSel = sel != null;
            updateButton.setDisable(!hasSel);
            deleteButton.setDisable(!hasSel);

            if (hasSel) {
                nameField.setText(sel.getName());
                emailField.setText(sel.getEmail());
            }
        });
    }

    @FXML
    private void onCreate() {
        String name = safeTrim(nameField.getText());
        String email = safeTrim(emailField.getText());

        if (name.isEmpty() || email.isEmpty()) {
            warn("Manglende input", "Udfyld både navn og email.");
            return;
        }

        Customer c = new Customer(name, email);

        // DAO returnerer kunden med id sat, så bruges return-værdien:
        Customer created = dao.create(c);

        // Add til table (ellers sker der “ingenting” i UI)
        customers.add(created);

        clear();
    }

    @FXML
    private void onUpdate() {
        Customer sel = customersTable.getSelectionModel().getSelectedItem();
        if (sel == null) return;

        String name = safeTrim(nameField.getText());
        String email = safeTrim(emailField.getText());

        if (name.isEmpty() || email.isEmpty()) {
            warn("Manglende input", "Udfyld både navn og email.");
            return;
        }

        sel.setName(name);
        sel.setEmail(email);

        dao.updateCustomer(sel);
        customersTable.refresh();
        clear();
    }

    @FXML
    private void onDelete() {
        Customer sel = customersTable.getSelectionModel().getSelectedItem();
        if (sel == null) return;

        // hvis du har dao.delete(sel.getId()); så kald den her
        // dao.delete(sel.getId());

        dao.deleteCustomer(sel.getId());
        customers.remove(sel);
        clear();

    }

    @FXML
    private void onClear() {
        clear();
    }

    private void clear() {
        nameField.clear();
        emailField.clear();
        customersTable.getSelectionModel().clearSelection();
        updateButton.setDisable(true);
        deleteButton.setDisable(true);
        nameField.requestFocus();
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }

    private void warn(String header, String content) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Validering");
        a.setHeaderText(header);
        a.setContentText(content);
        a.showAndWait();
    }
}
