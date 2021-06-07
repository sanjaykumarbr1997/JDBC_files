package com.xworkz.xworkzapp.amazon.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.amazon.dto.AmazonDTO;

public interface AmazonService {
	
	public void validateOrderDetails(AmazonDTO amazonDTO) throws ClassNotFoundException ,SQLException;
	public void validateUpdateDeliveryStatusByName(Boolean status,String Name) throws ClassNotFoundException ,SQLException;
	public void validateDeleteDetailsByName(String Name) throws ClassNotFoundException ,SQLException;
	public List<AmazonDTO> validateGetAllOrderDetails() throws ClassNotFoundException,SQLException;
	public List<AmazonDTO> validateGetOrderDetailsInAscendingOrder() throws ClassNotFoundException,SQLException; 
	public List<Float> validateGetMaxPriceOrderItem() throws ClassNotFoundException,SQLException;

}
