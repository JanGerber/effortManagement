package com.effortmanagement.dao;

import com.effortmanagement.interfaces.UserInterface;
import com.effortmanagement.model.CreateUser;
import com.effortmanagement.model.User;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDatabase extends DatenDAO implements UserInterface{
	
	private final Logger logger = LoggerFactory.getLogger(UserDatabase.class);
	
	public String getPasswort(String userName){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String password = null; 
		ResultSet rs =null;

		String selectSQL = "Select passwort from user where userName like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userName);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    password = rs.getString(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Error(getPasswort) ");
			logger.error(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return password;
	}
	public User getUserByName(String userName) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		User user = new User();
		ResultSet rs =null;

		String selectSQL = "Select userName, hochschule, email, userID from user where userName like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userName);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    user.setUserId(rs.getInt(4));
					    user.setHochschule(rs.getString(2));
					    user.setEmail(rs.getString(3));
					    user.setUserName(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			logger.error("getUserByName");
			logger.error(e.getMessage());
			user = null;
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return user;
	}

	public int newUser(CreateUser user) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "INSERT INTO user (userName, passwort, email, hochschule) VALUES (?,?, ?, ?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
	
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPasswort());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getHochschule());
			rs = preparedStatement.executeUpdate();
            ResultSet keyRs = preparedStatement.getGeneratedKeys();
            if(keyRs != null && keyRs.next()){
               rs = keyRs.getInt(1);
            }
		} catch (SQLException e) {
			logger.error("newUser");
			logger.error(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return rs;
	}

	public int changePasswort(int userId, String newPasswort) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE user SET passwort= ? WHERE userID LIKE ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, newPasswort);
			preparedStatement.setInt(2, userId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changePasswort");
			logger.error(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	
	}

	public int changeEmail(int userId, String newEmail) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE user SET email= ? WHERE userID LIKE ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, newEmail);
			preparedStatement.setInt(2, userId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changePasswort");
			logger.error(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
	public int changeHochschule(int userId, String newHochschule) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE user SET hochschule= ? WHERE userID LIKE ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, newHochschule);
			preparedStatement.setInt(2, userId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeHochschule");
			logger.error(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
	public int changeUserName(int userId, String newUserName) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE user SET userName= ? WHERE userID LIKE ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, newUserName);
			preparedStatement.setInt(2, userId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeUserName");
			logger.error(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rs;
	}
	
	public int changeData (int userId, String args){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;
		
		changeArg(userId, args, dbConnection, preparedStatement, rs);
		return rs;
	}
	
	
	
	public void changeArg(int userId, String arg, Connection dbConnection, PreparedStatement preparedStatement, int rs){
		String selectSQL = "UPDATE user SET " + arg + " userName= ? WHERE userID LIKE ?" ;
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, arg);
			preparedStatement.setInt(2, userId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeParameter");
			logger.error(e.getMessage());
		}
		finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}

	public User getUserById(int userID) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		User user = new User();
		ResultSet rs =null;

		String selectSQL = "Select userName, hochschule, email, userID from user where userID like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, userID);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    user.setUserId(rs.getInt(4));
					    user.setHochschule(rs.getString(2));
					    user.setEmail(rs.getString(3));
					    user.setUserName(rs.getString(1));
				}
			}
		} catch (SQLException e) {
			logger.error("getUserByName");
			logger.error(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return user;
	}
	public String getPasswort(int userId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String password = null; 
		ResultSet rs =null;

		String selectSQL = "Select passwort from user where userID like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    password = rs.getString(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Error(getPasswort) ");
			logger.error(e.getMessage());

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return password;
	}
}