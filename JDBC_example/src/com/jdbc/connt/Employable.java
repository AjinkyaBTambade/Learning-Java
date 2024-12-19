package com.jdbc.connt;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements Employable {
    private final EmployeeReposirty repository;

    public EmployeeService(EmployeeReposirty repository) {
        this.repository = repository;
    }

    @Override
    public boolean addEmployee(Employee emp) {
        try {
            repository.create(emp);
            return true;
        } catch (Exception e) {
            System.err.println("Error adding employee: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        return repository.readAll();
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        try {
            repository.update(emp);
            return true;
        } catch (Exception e) {
            System.err.println("Error updating employee: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();
        repository.delete(id);
    }
}
