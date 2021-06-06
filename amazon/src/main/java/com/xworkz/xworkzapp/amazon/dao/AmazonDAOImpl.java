package com.xworkz.xworkzapp.amazon.dao;

import static com.xworkz.xworkzapp.amazon.constants.Constants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.xworkzapp.amazon.dto.AmazonDTO;

public class AmazonDAOImpl implements AmazonDAO {
	
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
	public void createOrderDetails(AmazonDTO amazonDTO) throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedStatement1=null;
		try {
			preparedStatement1 = getConnection().prepareStatement(INSERT_QUERY);
			preparedStatement1.setInt(1,amazonDTO.getId());
			preparedStatement1.setString(2, amazonDTO.getName());
			preparedStatement1.setString(3, amazonDTO.getOrderedItem());
			preparedStatement1.setFloat(4, amazonDTO.getItemPrice());
			preparedStatement1.setLong(5, amazonDTO.getContactNo());
			preparedStatement1.setBoolean(6, amazonDTO.getDeliverStatus());
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
	public void updateDeliveryStatusByName(Boolean status,String Name) throws ClassNotFoundException, SQLException {

		PreparedStatement preparedStatement2 =null;
		try {
			preparedStatement2 = getConnection().prepareStatement(UPDATE_DELIVERY_STATUS_BY_NAME);
			preparedStatement2.setBoolean(1,status);
			preparedStatement2.setString(2, Name);
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
	public void deleteDetailsByName(String Name) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement3 =null;
		try {
			preparedStatement3 = getConnection().prepareStatement(DELETE_QUERY);
			preparedStatement3.setString(1, Name);
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
	public List<AmazonDTO> getAllOrderDetails() throws ClassNotFoundException, SQLException {
		Statement statement = getConnection().createStatement();
		ResultSet resultSet=statement.executeQuery(SELECT_QUERY);
		List<AmazonDTO> amazonDTOs = new ArrayList<>();
		
		while (resultSet.next()) {

            AmazonDTO bankDTO = new AmazonDTO();
            bankDTO.setId(resultSet.getInt("id"));
            bankDTO.setName(resultSet.getString("name"));
            bankDTO.setOrderedItem(resultSet.getString("ordered_item"));
            bankDTO.setItemPrice(resultSet.getFloat("item_price"));
            bankDTO.setContactNo(resultSet.getLong("contact_number"));
            bankDTO.setDeliverStatus(resultSet.getBoolean("delivery_status"));
            amazonDTOs.add(bankDTO);
		}
		
		statement.close();
		closeConnection();
		return amazonDTOs;	  


	}

}
