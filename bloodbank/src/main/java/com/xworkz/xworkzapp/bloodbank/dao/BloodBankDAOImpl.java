package com.xworkz.xworkzapp.bloodbank.dao;

import com.xworkz.xworkzapp.bloodbank.dto.BloodBankDTO;


import static com.xworkz.xworkzapp.bloodbank.constants.Constants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BloodBankDAOImpl implements BloodBankDAO {

	@Override
	public void createBloodBankDetails(BloodBankDTO bloodDTO) throws ClassNotFoundException, SQLException {
		
		
		 
			Class.forName(DRIVER_CLASS_NAME);
			Connection connection = DriverManager.getConnection(URL);
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setInt(1,bloodDTO.getBloodBankID());
			preparedStatement.setString(2, bloodDTO.getDonorName());
			preparedStatement.setInt(3, bloodDTO.getDonorAge());
			preparedStatement.setLong(4, bloodDTO.getContactNo());
			preparedStatement.setBoolean(5, bloodDTO.isSmoker());
			preparedStatement.setString(6, bloodDTO.getBloodBankLocation());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		
	}

	@Override
	public void updateAgeByName(int donorAge,String donorName) throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL);
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_AGE_BY_DONOR_NAME);
		preparedStatement.setInt(1,donorAge);
		preparedStatement.setString(2, donorName);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		
	}

	@Override
	public void deleteDetailsByName(String donorName) throws ClassNotFoundException, SQLException {

		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL);
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
		preparedStatement.setString(1, donorName);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}

	@Override
	public List<BloodBankDTO> getAllBloodBankDetails() throws ClassNotFoundException, SQLException  {
		
		Class.forName(DRIVER_CLASS_NAME);
	
			Connection connection = DriverManager.getConnection(URL);
			Statement statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery(SELECT_QUERY);
			List<BloodBankDTO> bankDTOs = new ArrayList<>();
			
			while (resultSet.next()) {

                BloodBankDTO bankDTO = new BloodBankDTO();
                bankDTO.setBloodBankID(resultSet.getInt("blood_bank_id"));
                bankDTO.setDonorName(resultSet.getString("donor_name"));
                bankDTO.setBloodBankID(resultSet.getInt("donor_age"));
                bankDTO.setContactNo(resultSet.getLong("donor_contact_number"));
                bankDTO.setSmoker(resultSet.getBoolean("is_smoker"));
                bankDTO.setBloodBankLocation(resultSet.getString("blood_bank_location"));
                
                bankDTOs.add(bankDTO);
			}
			
			
			statement.close();
			connection.close();
			
			return bankDTOs;
            
		
		  
	}

}
