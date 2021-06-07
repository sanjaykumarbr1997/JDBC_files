package com.xworkz.xworkzapp.playstore.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.playstore.dto.PlayStoreDTO;

public interface PlayStoreService {
	
	public void validateAndSave(PlayStoreDTO pDTO) throws ClassNotFoundException, SQLException;
	public void validateAndUpdateRatingsByName(int ratings,String appName) throws ClassNotFoundException, SQLException;
	public void deleteDetailsByName(String appName) throws ClassNotFoundException, SQLException;
	public List<PlayStoreDTO> validateAndFetch() throws ClassNotFoundException, SQLException;
	public List<Integer> validateGetMaxRatings() throws ClassNotFoundException,SQLException;
	public List<PlayStoreDTO> validateGetAppsByRatings(int rating) throws ClassNotFoundException,SQLException;
	public List<PlayStoreDTO> validateGetAppsByType(String type) throws ClassNotFoundException,SQLException;
	
	
}
