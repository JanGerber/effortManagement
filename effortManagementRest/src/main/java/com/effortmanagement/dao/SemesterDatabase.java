package com.effortmanagement.dao;


import com.effortmanagement.model.CreateSemester;
import com.effortmanagement.model.Semester;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SemesterDatabase extends DatenDAO {
	
	private final Logger logger = LoggerFactory.getLogger(SemesterDatabase.class);
	
	public List<Semester> getSemesterList(int userId){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<Semester> semesterList = new ArrayList<Semester>();
		ResultSet rs =null;

		String selectSQL = "Select semesterId, semesterName, startDatum, endDatum, user_Id from semester where user_Id like ? ORDER BY startDatum";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, userId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    Semester semester = new Semester();
					    semester.setSemesterId(rs.getInt(1));
					    semester.setSemesterName(rs.getString(2));
					    semester.setStartDatum(rs.getString(3));
					    semester.setEndDatum(rs.getString(4));
					    semester.setUser_Id(rs.getInt(5));
					    semesterList.add(semester);
					}
			}
		} catch (SQLException e) {
			logger.error("getSemesterList");
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
		return semesterList;
		
	}
	public int changeSemesterName(int semesterId, String semesterName) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE semester SET semesterName = ? WHERE semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, semesterName);
			preparedStatement.setInt(2, semesterId);

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeSemesterName");
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
	public int changeEndDatum(int semesterId, String endDatum) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE semester SET endDatum = ? WHERE semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1,endDatum);
			preparedStatement.setInt(2, semesterId);
			
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeEndDatum");
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
	public int changeStartDatum(int semesterId, String startDatum) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE semester SET startDatum= ? WHERE semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, startDatum);
			preparedStatement.setInt(2, semesterId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeStartDatum");
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
	
	public int newSemester(CreateSemester semester) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "INSERT INTO semester (semesterName, startDatum, endDatum, user_Id) VALUES (?, ?, ?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
	
			preparedStatement.setString(1, semester.getSemesterName());
			preparedStatement.setString(2, semester.getStartDatum());
			preparedStatement.setString(3, semester.getEndDatum());
			preparedStatement.setInt(4, semester.getUser_Id());
			rs = preparedStatement.executeUpdate();
            ResultSet keyRs = preparedStatement.getGeneratedKeys();
            if(keyRs != null && keyRs.next()){
               rs = keyRs.getInt(1);
            }
		} catch (SQLException e) {
			logger.error("newSemester");
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
	
	public int deleteSemester(int semesterId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs =0;

		String selectSQL = "DELETE FROM semester where semesterId LIKE ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("deleteSemester");
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
	public Semester getSemester(int semesterId){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Semester semester = new Semester();
		ResultSet rs = null;

		String selectSQL = "Select semesterId, semesterName, startDatum, endDatum, user_Id from semester where semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					  semester.setSemesterId(rs.getInt(1));
					  semester.setSemesterName(rs.getString(2));
					  semester.setStartDatum(rs.getString(3));
					  semester.setEndDatum(rs.getString(4));
					  semester.setUser_Id(rs.getInt(5));
				}
			}
		} catch (SQLException e) {
			logger.error("getSemester");
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
		return semester;
	}
}
