package com.effortmanagement.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface UserInterface {
	
	//only changes of database entries implemented
	//new entries should be added
	public int changeData(int userId, String args);
}
