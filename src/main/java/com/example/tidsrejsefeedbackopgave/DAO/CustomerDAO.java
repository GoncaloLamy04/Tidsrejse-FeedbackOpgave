package com.example.tidsrejsefeedbackopgave.DAO;

import com.example.tidsrejsefeedbackopgave.DB.DatabaseConnector;
import com.example.tidsrejsefeedbackopgave.Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public Customer create(Customer customer) {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    customer.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println("DB-fejl: " + e.getMessage());
        }
        return customer;
    }

    public List<Customer> readAll() {
        String sql = "SELECT id, name, email FROM customer ORDER BY id";
        List<Customer> list = new ArrayList<>();

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("id")
                ));
            }

        } catch (SQLException e) {
            System.out.println("DB-fejl: " + e.getMessage());
        }
        return list;
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customer SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setInt(3, customer.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB-fejl: " + e.getMessage());
        }
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DB-fejl: " + e.getMessage());
        }
    }
}
