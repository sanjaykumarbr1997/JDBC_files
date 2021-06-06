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

	@Override
	public void create_details(PlayStoreDTO pDTO) throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL);
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
		preparedStatement.setInt(1,pDTO.getId());
		preparedStatement.setString(2, pDTO.getAppName());
		preparedStatement.setString(3, pDTO.getAppType());
		preparedStatement.setInt(4, pDTO.getRatings());
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	@Override
	public void updateRatingsByName(int ratings, String appName) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL);
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RATINGS_BY_APP_NAME);
		preparedStatement.setInt(1,ratings);
		preparedStatement.setString(2, appName);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	@Override
	public void deleteDetailsByName(String appName) throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL);
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setString(1, appName);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		
	}

	@Override
	public List<PlayStoreDTO> getAllBloodBankDetails() throws ClassNotFoundException, SQLException {
		
		Class.forName(DRIVER_CLASS_NAME);
		
		Connection connection = DriverManager.getConnection(URL);
		Statement statement = connection.createStatement();
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
		connection.close();
		
		return playDTOs;
        
	
	}

}
