package com.xworkz.xworkzapp.amazon.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.amazon.dao.AmazonDAO;
import com.xworkz.xworkzapp.amazon.dao.AmazonDAOImpl;
import com.xworkz.xworkzapp.amazon.dto.AmazonDTO;

public class AmazonServiceImpl implements AmazonService{
	
	public AmazonDAO amazonDAO;
	
	public AmazonServiceImpl(){
		
		amazonDAO = new AmazonDAOImpl();
		
	}
	

	@Override
	public void validateOrderDetails(AmazonDTO amazonDTO) throws ClassNotFoundException, SQLException {
		
		if (amazonDTO != null) {
			amazonDAO.createOrderDetails(amazonDTO);
		}
		else {
			System.out.println("Invalid entry , please try again");
		}	
	

	}

	@Override
	public void validateUpdateDeliveryStatusByName(Boolean status, String Name) throws ClassNotFoundException, SQLException {
		if (Name != null) {
			amazonDAO.updateDeliveryStatusByName(status, Name);
		}
		else {
			System.out.println("Invalid entry , please try again");
		}	
	}

	@Override
	public void validateDeleteDetailsByName(String Name) throws ClassNotFoundException, SQLException {
		if (Name !=null) {
			amazonDAO.deleteDetailsByName(Name);
		}
		else {
			System.out.println("Name cant be empty");
		}
		
	}

	@Override
	public List<AmazonDTO> validateGetAllOrderDetails() throws ClassNotFoundException, SQLException {
		
		return amazonDAO.getAllOrderDetails();
	}


	@Override
	public List<AmazonDTO> validateGetOrderDetailsInAscendingOrder() throws ClassNotFoundException, SQLException {
		
		return amazonDAO.getOrderDetailsInAscendingOrder();
	}


	@Override
	public List<Float> validateGetMaxPriceOrderItem() throws ClassNotFoundException, SQLException {
		
		return amazonDAO.getMaxPriceOrderItem();
	}


	@Override
	public List<Float> validateGetAveragePriceOrderItem() throws ClassNotFoundException, SQLException {
		return amazonDAO.getAveragePriceOrderItem();
	}

}
