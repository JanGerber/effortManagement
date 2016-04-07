package com.effortmanagement.dao;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DatenDAO {

	protected static final String DB_DRIVER = "org.h2.Driver";
	protected static final String DB_CONNECTION = "jdbc:h2:~/effortManagementDB;AUTO_SERVER=TRUE";
	protected static final String DB_USER = "sa";
	protected static final String DB_PASSWORD = "";


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