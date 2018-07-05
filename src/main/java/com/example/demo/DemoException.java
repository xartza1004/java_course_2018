package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoException {

	public static void main(String[] args) {
		DemoException hello = new DemoException();
		hello.start();
	}

	private void start() {
		UserDatabase userDatabase = new UserDatabase();
		try {
			userDatabase.getName(1);
		} catch (UserNotFoundException | InternalInException | DatabaseProblemException e) {
			e.printStackTrace();
		}
		
		try {
			div(1, 0);
		} catch (InputCantZeroValueException e) {
			System.out.println("Error");
		}
	}

	private double div(int a, int b) {
		if (b != 0) {
			return a / b;
		}
		throw new InputCantZeroValueException();
	}

	class UserDatabase {
		public String getName(int id) throws UserNotFoundException, InternalInException, DatabaseProblemException {
			try {
				Class.forName("mysql.xxxx");
				Connection connection = DriverManager.getConnection("url");
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TABLE");
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					return resultSet.getString("NAME");
				}
				throw new UserNotFoundException();
			} catch (ClassNotFoundException e) {
				throw new InternalInException();
			} catch (SQLException e) {
				throw new DatabaseProblemException();
			}
		}
	}

	class DatabaseProblemException extends Exception {

	}

	class InputCantZeroValueException extends RuntimeException {

	}

	class InternalInException extends Exception {

	}

	class UserNotFoundException extends Exception {

	}

}
