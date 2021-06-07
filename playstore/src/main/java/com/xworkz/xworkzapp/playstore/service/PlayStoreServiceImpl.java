package com.xworkz.xworkzapp.playstore.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.playstore.dao.PlayStoreDAO;
import com.xworkz.xworkzapp.playstore.dao.PlayStoreDAOImpl;
import com.xworkz.xworkzapp.playstore.dto.PlayStoreDTO;

public class PlayStoreServiceImpl implements PlayStoreService {
	
	
private PlayStoreDAO playDAO;
    
    public  PlayStoreServiceImpl() {
    	
    	playDAO = new PlayStoreDAOImpl();
    	
    }

	@Override
	public void validateAndSave(PlayStoreDTO pDTO) throws ClassNotFoundException, SQLException {
		if (pDTO != null) {
			if (pDTO.getRatings() > 0 &&pDTO.getRatings() <6  && pDTO.getAppName() != null) {
				playDAO.create_details(pDTO);
			}
			else {
				System.out.println("Ratings above 5 and below 0 not accepted");
			}
		}
		else {
			System.out.println("Invalid entry , please try again");
		}	
		
	}

	@Override
	public void validateAndUpdateRatingsByName(int ratings, String appName) throws ClassNotFoundException, SQLException {
		
		if (ratings>0 && ratings<6  && appName !=null) {
			playDAO.updateRatingsByName(ratings,appName);
		}
		else {
			System.out.println("Age below 18 cant accept blood");
		}
		
		
	}

	@Override
	public void deleteDetailsByName(String appName) throws ClassNotFoundException, SQLException {
		if (appName !=null) {
			playDAO.deleteDetailsByName(appName);
		}
		else {
			System.out.println("Name cant be empty");
		}
	
		
	}

	@Override
	public List<PlayStoreDTO> validateAndFetch() throws ClassNotFoundException, SQLException {
		return playDAO.getAllBloodBankDetails();
	}

	@Override
	public List<Integer> validateGetMaxRatings() throws ClassNotFoundException, SQLException {
		return playDAO.getMaxRatings();
	}

	@Override
	public List<PlayStoreDTO> validateGetAppsByRatings(int rating) throws ClassNotFoundException, SQLException {
		return playDAO.getAppsByRatings(rating);
	}

	@Override
	public List<PlayStoreDTO> validateGetAppsByType(String type) throws ClassNotFoundException, SQLException {
		return playDAO.getAppsByType(type);
	}

}
