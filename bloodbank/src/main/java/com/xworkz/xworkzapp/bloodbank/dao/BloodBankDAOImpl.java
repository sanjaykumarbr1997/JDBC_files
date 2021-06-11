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
	
	Connection connection = null;
	
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
	public void createBloodBankDetails(BloodBankDTO bloodDTO) throws ClassNotFoundException, SQLException  {
		
			
			PreparedStatement preparedStatement1=null;
			try {
				preparedStatement1 = getConnection().prepareStatement(INSERT_QUERY);
				preparedStatement1.setInt(1,bloodDTO.getBloodBankID());
				preparedStatement1.setString(2, bloodDTO.getDonorName());
				preparedStatement1.setInt(3, bloodDTO.getDonorAge());
				preparedStatement1.setLong(4, bloodDTO.getContactNo());
				preparedStatement1.setBoolean(5, bloodDTO.isSmoker());
				preparedStatement1.setString(6, bloodDTO.getBloodBankLocation());
				//preparedStatement1.executeUpdate();
				//getConnection().commit();
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
	public void updateAgeByName(int donorAge,String donorName)throws ClassNotFoundException, SQLException  {

		PreparedStatement preparedStatement2 =null;
		try {
			preparedStatement2 = getConnection().prepareStatement(UPDATE_AGE_BY_DONOR_NAME);
			preparedStatement2.setInt(1,donorAge);
			preparedStatement2.setString(2, donorName);
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
	public void deleteDetailsByName(String donorName) throws ClassNotFoundException, SQLException {

		
		PreparedStatement preparedStatement3 =null;
		try {
			preparedStatement3 = getConnection().prepareStatement(DELETE_QUERY);
			preparedStatement3.setString(1, donorName);
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
	public List<BloodBankDTO> getAllBloodBankDetails() throws ClassNotFoundException, SQLException  {
		
			Statement statement = getConnection().createStatement();
			ResultSet resultSet=statement.executeQuery(SELECT_QUERY);
			List<BloodBankDTO> bankDTOs = new ArrayList<>();
			
			while (resultSet.next()) {

                BloodBankDTO bankDTO = new BloodBankDTO();
                bankDTO.setBloodBankID(resultSet.getInt("blood_bank_id"));
                bankDTO.setDonorName(resultSet.getString("donor_name"));
                bankDTO.setDonorAge(resultSet.getInt("donor_age"));
                bankDTO.setContactNo(resultSet.getLong("donor_contact_number"));
                bankDTO.setSmoker(resultSet.getBoolean("is_smoker"));
                bankDTO.setBloodBankLocation(resultSet.getString("blood_bank_location"));
                bankDTOs.add(bankDTO);
			}
			
			statement.close();
			closeConnection();
			return bankDTOs;	  
	}
	
	@Override
	public List<Boolean> getIsSmokerByName(String name) throws ClassNotFoundException, SQLException {

		PreparedStatement preparedstatement4 = null;
		 List<Boolean> issmoke = new ArrayList<>();

        try {
           
            preparedstatement4 = getConnection().prepareStatement(SELECT_ISSMOKER_BY_NAME);
            preparedstatement4.setString(1, name);
            ResultSet resultSet = preparedstatement4.executeQuery();
           
            while (resultSet.next()) {
            issmoke.add(resultSet.getBoolean(1));
           
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	preparedstatement4.close();
        	
        	closeConnection();
        }
        return issmoke;
	}

	@Override
	public List<BloodBankDTO> getDetailsByLocation(String location) throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedstatement4 = null;
		 List<BloodBankDTO> locBDTOs = new ArrayList<>();

       try {
           preparedstatement4 = getConnection().prepareStatement(SELECT_BY_LOCATION);
           preparedstatement4.setString(1, location);
           ResultSet resultSet = preparedstatement4.executeQuery();
          
           BloodBankDTO bankDTO = new BloodBankDTO();
           while (resultSet.next()) {
           bankDTO.setBloodBankID(resultSet.getInt("blood_bank_id"));
           bankDTO.setDonorName(resultSet.getString("donor_name"));
           bankDTO.setDonorAge(resultSet.getInt("donor_age"));
           bankDTO.setContactNo(resultSet.getLong("donor_contact_number"));
           bankDTO.setSmoker(resultSet.getBoolean("is_smoker"));
           bankDTO.setBloodBankLocation(resultSet.getString("blood_bank_location"));
           locBDTOs.add(bankDTO);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } 
       finally {
       	preparedstatement4.close();
       	
       	closeConnection();
       }
       return locBDTOs;
		
	}
	
	
	@Override
	public List<String> getAllContactNumber() throws ClassNotFoundException, SQLException {
		Statement statement = null;
        List<String> allNumber = new ArrayList<>();

        try {
            
            statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CONTACT_NUMBER);

            while (resultSet.next()) {
              
            	allNumber.add(resultSet.getString("donor_contact_number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	statement.close();
        	
        	closeConnection();
        }
        return allNumber;
	
	}

	

}
