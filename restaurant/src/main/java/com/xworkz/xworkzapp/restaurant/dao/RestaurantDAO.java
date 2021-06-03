package com.xworkz.xworkzapp.restaurant.dao;

import java.util.List;

import com.xworkz.xworkzapp.restaurant.dto.RestaurantDTO;

public interface RestaurantDAO {
	
	public void createDetails(RestaurantDTO rDTO);
	public  List<RestaurantDTO> getAllDetails(); 
	

}
