package com.effortmanagement.dao;


import com.effortmanagement.dao.*;
import java.sql.*;

public class SemesterDatabase extends AccesDatabase {
	private ResultSet r;
	public SemesterDatabase(){
	connectDB();
	}
	public ResultSet getSemester(int userId){
		try{
			r = stmt.executeQuery("Select * from semester where user_Id like '"+userId+"' ORDER BY startDatum");
			return r;
		}catch(Exception ex){
			return null;
		}
		
	}
	public boolean changeSemesterName(int semesterId, String semesterName) {
		try {
			stmt.executeUpdate("UPDATE semester SET semesterName= '"+ semesterName +"' WHERE semesterId like '" + semesterId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeEndDatum(int semesterId, String endDatum) {
		try {
			stmt.executeUpdate("UPDATE semester SET endDatum= '"+ endDatum +"' WHERE semesterId like '" + semesterId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeStartDatum(int semesterId, String startDatum) {
		try {
			stmt.executeUpdate("UPDATE semester SET startDatum= '"+ startDatum +"' WHERE semesterId like '" + semesterId + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void newSemester(String semesterName,String startDatum,String endDatum,int user_Id) {
		
		try {
			stmt.executeUpdate("INSERT INTO semester (semesterName, startDatum, endDatum, user_Id) VALUES ('"+semesterName+"', '"+startDatum+"', '"+endDatum+"', '"+user_Id+"')");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteSemester(int semesterId) {
		
		try {
			stmt.executeUpdate("DELETE FROM semester where semesterId LIKE '" + semesterId + "'");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
