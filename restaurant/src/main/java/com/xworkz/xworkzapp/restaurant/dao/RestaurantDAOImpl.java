package com.xworkz.xworkzapp.restaurant.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.xworkzapp.restaurant.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public void createDetails(RestaurantDTO restDTO) {
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn","root","dontknow");
			statement = connection.createStatement();
			statement.execute("insert into customer_order_details values("+restDTO.getCustomerID()+",'" +restDTO.getCustomerName()+" ','" +restDTO.getcustomerOrderedItem()+" '," +restDTO.getCustomerRatings()+" )");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
	}

	@Override
	public List<RestaurantDTO> getAllDetails() {
		
		List<RestaurantDTO> rstDTOs= new ArrayList();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn","root","dontknow");
			statement = connection.createStatement();
			ResultSet resultSet =statement.executeQuery("select*from customer_order_details");
			
			while(resultSet.next()) {
				
				RestaurantDTO rtdDTO = new RestaurantDTO();
				
				rtdDTO.setCustomerID(resultSet.getInt("customerID"));
				rtdDTO.setCustomerName(resultSet.getString("customerName"));
				rtdDTO.setCustomerOrderedItem(resultSet.getString("customerOrderedItem"));
				rtdDTO.setCustomerRatings(resultSet.getInt("customerRatings"));
				rstDTOs.add(rtdDTO);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		return rstDTOs;
	}

}
