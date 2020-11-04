package com.DAO.SBA3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Load the DB Driver (class) : Load a class
			Class.forName("com.mysql.jdbc.Driver");
			
			// Set up connection
			// DriverManager.getConnection("<url>","<username>","<password>")
	
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost/employeenewdb","root","root");
			
			// by default an open connection
			// Create a statement
			Statement stmt = connection.createStatement();
			
			ResultSet rs =  stmt.executeQuery("select * from employe"); // select
			
			// need to move record pointer
			/*
			 * if(rs.next()) { // fetch the record int id = rs.getInt("Id"); String name =
			 * rs.getString("Name"); String designation = rs.getString("Designation");
			 * String location = rs.getString("Location");
			 * 
			 * System.out.println("ID -> " + id); System.out.println("Name -> " + name);
			 * System.out.println("Designation -> " + designation);
			 * System.out.println("Location -> " + location); }
			 */
			
			while(rs.next()) {
				
				// fetch complete records
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String designation = rs.getString("Designation");
				String location = rs.getString("Location");
				
				System.out.println("ID -> " + id);
				System.out.println("Name -> " + name);
				System.out.println("Designation -> " + designation);
				System.out.println("Location -> " + location);
				System.out.println("------------------------------------");
			}
			
			connection.close();
			rs.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
