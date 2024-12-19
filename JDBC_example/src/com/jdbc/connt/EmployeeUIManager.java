package com.jdbc.connt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeUIManager {
    private final Employable service;

    public EmployeeUIManager(Employable service) {
        this.service = service;
    }

    public Employee acceptEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        return new Employee(0, name, dept, salary);
    }

    public void viewEmployees() {
        try {
            List<Employee> employees = service.getEmployees();
            System.out.println("\nID | Name | Department | Salary");
            System.out.println("-------------------------------");
            for (Employee emp : employees) {
                System.out.printf("%d | %s | %s | %.2f%n", emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary());
            }
        } catch (SQLException e) {
            System.err.println("Error fetching employees: " + e.getMessage());
        }
    }

    public void addEmployee() {
        Employee emp = acceptEmployee();
        if (service.addEmployee(emp)) {
            System.out.println("Employee added successfully.");
        } else {
            System.err.println("Failed to add employee.");
        }
    }

    public void removeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();
        try {
            service.deleteEmployee(null, sc);
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }
}
