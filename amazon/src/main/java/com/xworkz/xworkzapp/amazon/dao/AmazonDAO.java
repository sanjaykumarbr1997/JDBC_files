package com.xworkz.xworkzapp.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.amazon.dto.AmazonDTO;


public interface AmazonDAO {
	
	public void createOrderDetails(AmazonDTO amazonDTO) throws ClassNotFoundException ,SQLException;
	public void updateDeliveryStatusByName(Boolean status,String Name) throws ClassNotFoundException ,SQLException;
	public void deleteDetailsByName(String Name) throws ClassNotFoundException ,SQLException;
	public List<AmazonDTO> getAllOrderDetails() throws ClassNotFoundException,SQLException;

}
