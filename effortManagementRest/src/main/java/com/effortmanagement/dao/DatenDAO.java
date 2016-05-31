package com.effortmanagement.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatenDAO {

	protected static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	protected static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/effortManagementDB";
	protected static final String DB_USER = "root";
	protected static final String DB_PASSWORD = "mysql";


	protected Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}

}