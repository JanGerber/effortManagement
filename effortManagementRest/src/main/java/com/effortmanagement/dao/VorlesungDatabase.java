package com.effortmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Semester;
import com.effortmanagement.model.Vorlesung;

public class VorlesungDatabase extends DatenDAO{
	
	private final Logger logger = LoggerFactory.getLogger(VorlesungDatabase.class);

	public List<Vorlesung> selectVorlesungListById(int semesterId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<Vorlesung> vorlesungList = new ArrayList<Vorlesung>();
		ResultSet rs =null;

		String selectSQL = "Select ################# from vorlesung where s like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    Vorlesung vorlesung = new Vorlesung();
					    //TODO  Vorlesung Attribute hinzufügen
					    vorlesungList.add(vorlesung);
					}
			}
		} catch (SQLException e) {
			logger.error("selectVorlesungListById");
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
		return vorlesungList;
	}

	public int changeAufwand(int vorlesungId, double neuerAufwand) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE vorlesung SET lernzeit = ? WHERE vorlesungId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setDouble(1, neuerAufwand);
			preparedStatement.setInt(2, vorlesungId);

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeAufwand");
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

	public Vorlesung selectVorlesungById(int vorlesungId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		Vorlesung vorlesung = new Vorlesung();
		ResultSet rs = null;

		String selectSQL = "Select ######## from vorlesung where vorlesungId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, vorlesungId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					  //TODO vorlesung füllen
				}
			}
		} catch (SQLException e) {
			logger.error("selectVorlesungById");
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
		return vorlesung;
	}

	public List<NoteVorlesung> selectNotenVorlesung(int semesterId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<NoteVorlesung> notenList = new ArrayList<NoteVorlesung>();
		ResultSet rs =null;

		String selectSQL = "Select ################# from semester where semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
						NoteVorlesung noteVorlesung = new NoteVorlesung();
					    //TODO  Noten Attribute hinzufügen
					    notenList.add(noteVorlesung);
					}
			}
		} catch (SQLException e) {
			logger.error("selectNotenVorlesung");
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
		return notenList;
	}

	public int insertSemester(CreateVorlesung vorlesung) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "INSERT INTO vorlesung (###################) VALUES (?, ?, ?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
	
			//TODO preparedStatement.setString(1, semester.getSemesterName());
			
			rs = preparedStatement.executeUpdate();
            ResultSet keyRs = preparedStatement.getGeneratedKeys();
            if(keyRs != null && keyRs.next()){
               rs = keyRs.getInt(1);
            }
		} catch (SQLException e) {
			logger.error("insertSemester");
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

}
