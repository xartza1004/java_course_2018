package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoJDBC {

	public static void main(String[] args) {
		DemoJDBC demoJDBC = new DemoJDBC();
		// demoJDBC.countDataFromDatabase();
		// demoJDBC.fetchAllDataFromDatabase();
		demoJDBC.fetchByCondition(1);
	}
	
	private void fetchByCondition(int id) {
		String url = "jdbc:mysql://35.240.204.236/sample?user=user01&password=password";
		String sql = "SELECT id, name from USER where id=?";
		
		// Try with resources
		try (
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement
				= connection.prepareStatement(sql);
		) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				// int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				System.out.printf("%d -> %s\n", id, name);
			}
			
			resultSet.close();
		} catch (SQLException e) {
			throw new RuntimeException("SQLException" + e.getMessage());
		}
	}
	
	private void fetchAllDataFromDatabase() {
		String url = "jdbc:mysql://35.240.204.236/sample?user=user01&password=password";
		
		// Try with resources
		try (
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement
				= connection.prepareStatement("SELECT id, name from USER");
				ResultSet resultSet = preparedStatement.executeQuery();
		) {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				System.out.printf("%d -> %s\n", id, name);
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException" + e.getMessage());
		}
	}
	
	private int countDataFromDatabase() {
		String url = "jdbc:mysql://35.240.204.236/sample?user=user01&password=password";
		
		// Try with resources
		try (
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement
				= connection.prepareStatement("SELECT count(1) as c from USER");
				ResultSet resultSet = preparedStatement.executeQuery();
		) {
			if (resultSet.next()) {
				int result = resultSet.getInt("c");
				System.out.println("No. of user = " + result);
				return result;
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQLException" + e.getMessage());
		}
		
		throw new RuntimeException("Data not found");
	}

	private int countDataFromDatabaseOld() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// 1. Load DB driver class
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Create connection
			String url = "jdbc:mysql://35.240.204.236/sample?user=user01&password=password";
			connection = DriverManager.getConnection(url);
			// 3. Prepare statement :: SQL
			preparedStatement = connection.prepareStatement("SELECT count(1) as c from USER");
			// 4. Result of data from DB (SQL)
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int result = resultSet.getInt("c");
				System.out.println("No. of user = " + result);
				return result;
			}

		} catch (SQLException e) {
			throw new RuntimeException("SQLException" + e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("ClassNotFoundException" + e.getMessage());
		}

		try {
			// 5. Released resources
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException("SQLException" + e.getMessage());
		}
	}

}
