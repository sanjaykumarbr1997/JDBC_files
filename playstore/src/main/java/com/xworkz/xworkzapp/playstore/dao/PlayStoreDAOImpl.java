package com.xworkz.xworkzapp.playstore.dao;

import static com.xworkz.xworkzapp.playstore.constants.Constants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.xworkzapp.playstore.dto.PlayStoreDTO;

public class PlayStoreDAOImpl implements PlayStoreDAO {
	
	Connection connection =null;
	private Connection getConnection() {
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			connection = DriverManager.getConnection(URL);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void create_details(PlayStoreDTO pDTO) throws ClassNotFoundException, SQLException  {
		
	
		PreparedStatement preparedStatement1 =null;
		try {
			preparedStatement1 = getConnection().prepareStatement(INSERT_QUERY);
			preparedStatement1.setInt(1,pDTO.getId());
			preparedStatement1.setString(2, pDTO.getAppName());
			preparedStatement1.setString(3, pDTO.getAppType());
			preparedStatement1.setInt(4, pDTO.getRatings());
			preparedStatement1.addBatch();
			preparedStatement1.executeBatch();
			connection.commit();
			
			
		} catch (SQLException e) {
			connection.rollback();
		}
		finally {
			preparedStatement1.close();
			closeConnection();
		}
		
	}

	@Override
	public void updateRatingsByName(int ratings, String appName) throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedStatement2=null;
	try {
		preparedStatement2 = getConnection().prepareStatement(UPDATE_RATINGS_BY_APP_NAME);
		preparedStatement2.setInt(1,ratings);
		preparedStatement2.setString(2, appName);
		preparedStatement2.addBatch();
		preparedStatement2.executeBatch();
		connection.commit();
		
	} catch (SQLException e) {
		connection.rollback();
	}
	finally {
		preparedStatement2.close();
		closeConnection();
	}
	
	}

	@Override
	public void deleteDetailsByName(String appName) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement3 =null;
	try {
		 preparedStatement3= getConnection().prepareStatement(DELETE_QUERY);
		preparedStatement3.setString(1, appName);
		preparedStatement3.addBatch();
		preparedStatement3.executeBatch();
		connection.commit();
		
	} catch (SQLException e) {
		connection.rollback();
	}
	finally {
		preparedStatement3.close();
		closeConnection();
	}
		
	}

	@Override
	public List<PlayStoreDTO> getAllBloodBankDetails() throws ClassNotFoundException, SQLException {
		
		Statement statement=null;
		
		statement = getConnection().createStatement();
		ResultSet resultSet=statement.executeQuery(SELECT_QUERY);
		List<PlayStoreDTO> playDTOs = new ArrayList<>();
		
		while (resultSet.next()) {

            PlayStoreDTO playDTO = new PlayStoreDTO();
            playDTO.setId(resultSet.getInt("id"));
            playDTO.setAppName(resultSet.getString("app_name"));
            playDTO.setAppType(resultSet.getString("app_type"));
            playDTO.setRatings(resultSet.getInt("app_ratings"));
            
            playDTOs.add(playDTO);
		}
		statement.close();
		closeConnection();
		
		return playDTOs;
        
	}

	@Override
	public List<Integer> getMaxRatings() throws ClassNotFoundException, SQLException {

		Statement statement=null;
		
		statement = getConnection().createStatement();
		ResultSet resultSet=statement.executeQuery(SELECT_MAX_RATING);
		List<Integer> maxint = new ArrayList<>();
		
		while (resultSet.next()) {
			Integer max ;
             max = resultSet.getInt(1);
            
             maxint.add(max);
		}
		statement.close();
		closeConnection();
		
		return maxint;
	}

	@Override
	public List<PlayStoreDTO> getAppsByRatings(int rating) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement3 =null;
		
			 preparedStatement3= getConnection().prepareStatement(SELECT_APP_BY_RATINGS);
			 preparedStatement3.setInt(1,rating);
			 ResultSet resultSet=preparedStatement3.executeQuery();
			 List<PlayStoreDTO> playDTOs = new ArrayList<>();
		
		while (resultSet.next()) {

            PlayStoreDTO playDTO = new PlayStoreDTO();
            playDTO.setId(resultSet.getInt("id"));
            playDTO.setAppName(resultSet.getString("app_name"));
            playDTO.setAppType(resultSet.getString("app_type"));
            playDTO.setRatings(resultSet.getInt("app_ratings"));
            
            playDTOs.add(playDTO);
		}
		preparedStatement3.close();
		closeConnection();
		
		return playDTOs;
	}

	@Override
	public List<PlayStoreDTO> getAppsByType(String type) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement3 =null;
		
		 preparedStatement3= getConnection().prepareStatement(SELECT_APP_BY_TYPE);
		 preparedStatement3.setString(1,type);
		 ResultSet resultSet=preparedStatement3.executeQuery();
		 List<PlayStoreDTO> playDTOs = new ArrayList<>();
	
	while (resultSet.next()) {

       PlayStoreDTO playDTO = new PlayStoreDTO();
       playDTO.setId(resultSet.getInt("id"));
       playDTO.setAppName(resultSet.getString("app_name"));
       playDTO.setAppType(resultSet.getString("app_type"));
       playDTO.setRatings(resultSet.getInt("app_ratings"));
       
       playDTOs.add(playDTO);
	}
	preparedStatement3.close();
	closeConnection();
	
	return playDTOs;
	}

}
