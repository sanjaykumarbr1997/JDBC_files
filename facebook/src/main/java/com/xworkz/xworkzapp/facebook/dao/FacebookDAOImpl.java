package com.xworkz.xworkzapp.facebook.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.xworkz.xworkzapp.facebook.constants.Constants.*;

import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;


public class FacebookDAOImpl implements  FacebookDAO {
	
	
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
    public void createFaceBook(FacebookDTO bookDTO) throws ClassNotFoundException, SQLException {
       
        PreparedStatement preparedstatement1 = null;

        try {
            preparedstatement1 = getConnection().prepareStatement(INSERT_QUERY);
            preparedstatement1.setInt(1, bookDTO.getId());
            preparedstatement1.setString(2, bookDTO.getName());
            preparedstatement1.setString(3, bookDTO.getEmail());
            preparedstatement1.setString(4, bookDTO.getName());
            preparedstatement1.addBatch();
            preparedstatement1.executeBatch();
            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
        } finally {
        	 preparedstatement1.close();
        	 closeConnection();

        }

    }
    
    @Override
	public void updatePasswordByName(String password, String name) throws ClassNotFoundException, SQLException {
    	PreparedStatement preparedstatement2 = null;
   
    try {
    	preparedstatement2 = getConnection().prepareStatement(UPDATE_PASSWORD_BY_NAME);
    	preparedstatement2.setString(1, password);
    	preparedstatement2.setString(2, name);
    	preparedstatement2.addBatch();
        preparedstatement2.executeBatch();
        connection.commit();
    	 } catch (SQLException e) {
             connection.rollback();
         } finally {
         	 preparedstatement2.close();
         	 closeConnection();

         }
   
	}

	@Override
	public void deleteDetailsByName(String name) throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedstatement3 = null;
		try {
	    	preparedstatement3 = getConnection().prepareStatement(DELETE_QUERY);
	    	preparedstatement3.setString(1, name);
	    	preparedstatement3.addBatch();
	        preparedstatement3.executeBatch();
	        connection.commit();
	    	 } catch (SQLException e) {
	             connection.rollback();
	         } finally {
	         	 preparedstatement3.close();
	         	 closeConnection();

	         }
		
		
	}

    @Override
    public List<FacebookDTO> getAllFaceBookDetails() throws SQLException {

        Statement statement = null;
        List<FacebookDTO> bookDTOs = new ArrayList<>();

        try {
            
            statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

            while (resultSet.next()) {

                FacebookDTO bookDTO = new FacebookDTO();
                bookDTO.setId(resultSet.getInt("facebook_id"));
                bookDTO.setName(resultSet.getString("facebook_name"));
                bookDTO.setEmail(resultSet.getString("facebook_email"));
                bookDTO.setPassword(resultSet.getString("facebook_password"));

                bookDTOs.add(bookDTO);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	statement.close();
        	
        	closeConnection();
        }
        return bookDTOs;

    }
	@Override
	public List<String> getAllEmails() throws ClassNotFoundException, SQLException {
		Statement statement = null;
        List<String> allEmail = new ArrayList<>();

        try {
            
            statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_EMAILS_QUERY);

            while (resultSet.next()) {
              
               allEmail.add(resultSet.getString("facebook_email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	statement.close();
        	
        	closeConnection();
        }
        return allEmail;
	
	}
	@Override
	public List<String> getPasswordByEmail(String email) throws ClassNotFoundException, SQLException {

		PreparedStatement preparedstatement4 = null;
		 List<String> passwo = new ArrayList<>();

        try {
           
            preparedstatement4 = getConnection().prepareStatement(SELECT_PASSWORD_BY_EMAIL);
            preparedstatement4.setString(1, email);
            ResultSet resultSet = preparedstatement4.executeQuery();
           
            while (resultSet.next()) {
            passwo.add(resultSet.getString("facebook_password"));
           
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	preparedstatement4.close();
        	
        	closeConnection();
        }
        return passwo;
	}
	@Override
	public List<String> getEmailByName(String name) throws ClassNotFoundException, SQLException {

		PreparedStatement preparedstatement5 = null;
		 List<String> eemail = new ArrayList<>();

        try {
           
            preparedstatement5 = getConnection().prepareStatement(SELECT_EMAIL_BY_NAME);
            preparedstatement5.setString(1, name);
            ResultSet resultSet = preparedstatement5.executeQuery();
           
            while (resultSet.next()) {
            eemail.add(resultSet.getString("facebook_email"));
           
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
        	preparedstatement5.close();
        	
        	closeConnection();
        }
        return eemail;
	}

	

}
