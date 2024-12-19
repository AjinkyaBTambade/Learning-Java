package com.jdbc.connt;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeDBRepository();
        Employable service = new EmployeeService(repository);
        EmployeeUIManager uiManager = new EmployeeUIManager(service);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> uiManager.addEmployee();
                case 2 -> uiManager.viewEmployees();
                case 3 -> uiManager.removeEmployee();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
