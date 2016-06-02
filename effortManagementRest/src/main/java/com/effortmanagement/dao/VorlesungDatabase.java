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

import com.effortmanagement.interfaces.VorlesungInterface;
import com.effortmanagement.model.CreateVorlesung;
import com.effortmanagement.model.EndNote;
import com.effortmanagement.model.NoteVorlesung;
import com.effortmanagement.model.Semester;
import com.effortmanagement.model.Vorlesung;

public class VorlesungDatabase extends DatenDAO implements VorlesungInterface{
	
	private final Logger logger = LoggerFactory.getLogger(VorlesungDatabase.class);

	public List<Vorlesung> selectVorlesungListById(int semesterId) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		List<Vorlesung> vorlesungList = new ArrayList<Vorlesung>();
		ResultSet rs =null;

		String selectSQL = "Select vorlesungId,vorlesungName, aufwand, geplanterAufwand,angestrebteNote,endNote,lernzeit,creditPoints, semesterId, userId from vorlesung where semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    Vorlesung vorlesung = new Vorlesung();
					    vorlesung.setVorlesungId(rs.getInt(1));
					    vorlesung.setVorlesungName(rs.getString(2));
					    vorlesung.setAufwand(rs.getInt(3));
					    vorlesung.setGeplanterAufwand(rs.getInt(4));
					    vorlesung.setAngestrebteNote(rs.getDouble(5));
					    vorlesung.setEndNote(rs.getDouble(6));
					    vorlesung.setLernzeit(rs.getDouble(7));
					    vorlesung.setCreditPoints(rs.getInt(8));
					    vorlesung.setSemesterId(rs.getInt(9));
					    vorlesung.setUserId(rs.getInt(10));
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

		String selectSQL = "Select vorlesungId,vorlesungName, aufwand, geplanterAufwand,angestrebteNote,endNote,lernzeit,creditPoints, semesterId, userId from vorlesung where vorlesungId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, vorlesungId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
					    vorlesung.setVorlesungId(rs.getInt(1));
					    vorlesung.setVorlesungName(rs.getString(2));
					    vorlesung.setAufwand(rs.getInt(3));
					    vorlesung.setGeplanterAufwand(rs.getInt(4));
					    vorlesung.setAngestrebteNote(rs.getDouble(5));
					    vorlesung.setEndNote(rs.getDouble(6));
					    vorlesung.setLernzeit(rs.getDouble(7));
					    vorlesung.setCreditPoints(rs.getInt(8));
					    vorlesung.setSemesterId(rs.getInt(9));
					    vorlesung.setUserId(rs.getInt(10));
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

		String selectSQL = "Select ################## from semester where semesterId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, semesterId);
			rs = preparedStatement.executeQuery();
			if(rs != null){
				
					while (rs.next()){
						NoteVorlesung noteVorlesung = new NoteVorlesung();
					    //TODO  Noten Attribute hinzuf�gen
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

	public int insertVorlesung(CreateVorlesung vorlesung) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "INSERT INTO vorlesung (vorlesungName, aufwand, geplanterAufwand,angestrebteNote,creditPoints, semesterId, userId,lernzeit) VALUES (?,?,?,?,?,?,?,?)";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL,Statement.RETURN_GENERATED_KEYS);
	
			preparedStatement.setString(1, vorlesung.getVorlesungName());
			preparedStatement.setInt(2, vorlesung.getAufwand());
			preparedStatement.setInt(3, vorlesung.getGeplanterAufwand());
			preparedStatement.setDouble(4, vorlesung.getAngestrebteNote());
			preparedStatement.setInt(5, vorlesung.getCreditPoints());
			preparedStatement.setInt(6, vorlesung.getSemesterId());
			preparedStatement.setInt(7, vorlesung.getUserId());
			preparedStatement.setInt(8, 0);
			
			
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

	public int changeEndnote(EndNote endNote) {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int rs = 0;

		String selectSQL = "UPDATE vorlesung SET endNote = ? WHERE vorlesungId like ?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			preparedStatement.setDouble(1, endNote.getEndNote());
			preparedStatement.setInt(2, endNote.getVorlesungId());

			rs = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("changeEndnote");
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
