package com.example.tidsrejsefeedbackopgave.DAO;

import com.example.tidsrejsefeedbackopgave.Model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static final String url = "jdbc:mysql://localhost:3306/tidsrejse";
    private static final String user = "root";
    private static final String password = "Benfica121!";

    public Customer create(Customer customer) {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt =
                     conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);
                    customer.setId(id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> readAll() {
        String sql = "SELECT id, name, email FROM customer ORDER BY id";
        List<Customer> list = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Customer c = new Customer(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("id")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateCustomer(Customer updateCustomer) {
        String sql = "UPDATE customer SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, updateCustomer.getName());
            stmt.setString(2, updateCustomer.getEmail());
            stmt.setInt(3, updateCustomer.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id){
        String sql = "DELETE FROM customer WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
