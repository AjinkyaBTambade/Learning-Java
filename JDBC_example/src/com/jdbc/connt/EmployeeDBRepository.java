package com.jdbc.connt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBReposirty implements EmployeeReposirty {
    static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String USER = "root";
    static final String PASSWORD = "Root";

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            stmt.setDouble(3, employee.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating employee: " + e.getMessage());
        }
    }

    @Override
    public Employee read(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("department"),
                            rs.getDouble("salary")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error reading employee: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getDepartment());
            stmt.setDouble(3, employee.getSalary());
            stmt.setInt(4, employee.getId());
            stmt.executeUpdate();
            System.out.println("Employee updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating employee: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error reading all employees: " + e.getMessage());
        }
        return employees;
    }
}
