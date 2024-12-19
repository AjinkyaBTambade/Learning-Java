package com.jdbc.connt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnet {


	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/mydatabase";  // Replace with your database name
	        String user = "root";  // Replace with your MySQL username
	        String password = "gR8!aVz4@2kP1bT7";  // Replace with your MySQL password

	        try {
	            // Establish a connection
	            Connection conn = DriverManager.getConnection(url, user, password);
	            System.out.println("Database connected successfully!");

	            // Create a statement
	            Statement stmt = conn.createStatement();

	            // Execute a query
	            String sql = "SELECT * FROM mytable";  // Replace with your table name
	            ResultSet rs = stmt.executeQuery(sql);

	            // Process the result set
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id"));
	                System.out.println("Name: " + rs.getString("name"));
	            }

	            // Close the connection
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



