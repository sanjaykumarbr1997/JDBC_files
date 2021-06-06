package com.xworkz.xworkzapp.playstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.playstore.dto.PlayStoreDTO;

public interface PlayStoreDAO {
	
	public void create_details(PlayStoreDTO pDTO) throws ClassNotFoundException ,SQLException;
	public void updateRatingsByName(int ratings,String appName) throws ClassNotFoundException ,SQLException;
	public void deleteDetailsByName(String appName) throws ClassNotFoundException ,SQLException;
	public List<PlayStoreDTO> getAllBloodBankDetails() throws ClassNotFoundException,SQLException;
	
	
	


}
