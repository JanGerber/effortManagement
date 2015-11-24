package com.effortmanagement.dao;
import java.sql.*;

public class AccesDatabase {
	protected Connection con;
	protected Statement stmt;
	private String serverName="localhost";
	private String portNumber="3306";
	private String databaseName="effortData";
	private String url="jdbc:mysql://localhost:3306/" + databaseName;
	private String userName="root";
	private String password="mysql";
	
	private String getConnectionUrl(){
		return url;
	}
	public Connection connectDB(){
		con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(getConnectionUrl(),userName, password);
			stmt=con.createStatement();
		}catch(Exception ex){
			return null;
		}
		return con;
	}


public void disConnectDB(){
	try{
		stmt.close();
		con.close();
		
	}catch(Exception ex){
		
	}
}

public Statement getStmt(){
	return stmt;
}
}
