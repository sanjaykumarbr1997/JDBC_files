package com.xworkz.xworkzapp.restaurant;

import com.xworkz.xworkzapp.restaurant.dao.RestaurantDAO;
import com.xworkz.xworkzapp.restaurant.dao.RestaurantDAOImpl;
import com.xworkz.xworkzapp.restaurant.dto.RestaurantDTO;

import java.util.List;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		RestaurantDTO rDTO = new RestaurantDTO();
		Scanner scanner = new Scanner(System.in);
		
		
		boolean enter = true;
		while(enter == true) {
		System.out.println("Enter customer id");
		rDTO.setCustomerID(scanner.nextInt());
		System.out.println("Enter name");
		rDTO.setCustomerName(scanner.next());
		System.out.println("Enter ordered item");
		rDTO.setCustomerOrderedItem(scanner.next());
		System.out.println("Enter ratings , max 5");
		rDTO.setCustomerRatings(scanner.nextFloat());
		
		System.out.println(rDTO);
		
		
		System.out.println("Do you want to enter more values ?");
		System.out.println("Enter 'Y' to enter or 'N' to exit");
		String input = scanner.next();
		
		
		if(input.equalsIgnoreCase("N")) {
			enter = false;
			scanner.close();
		}
		RestaurantDAO rsDAO = new RestaurantDAOImpl();
		rsDAO.createDetails(rDTO);
		
		
		}
		RestaurantDAO rsDAOs = new RestaurantDAOImpl();
		
		
		List<RestaurantDTO> getAllDTOs = rsDAOs.getAllDetails();
		for(RestaurantDTO allDTO:getAllDTOs) {
			System.out.println(allDTO);
			
		}
		
		

	}

}
