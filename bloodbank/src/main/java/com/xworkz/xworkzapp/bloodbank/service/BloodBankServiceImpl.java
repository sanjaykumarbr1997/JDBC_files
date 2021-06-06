package com.xworkz.xworkzapp.bloodbank.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.bloodbank.dao.BloodBankDAO;
import com.xworkz.xworkzapp.bloodbank.dto.BloodBankDTO;
import com.xworkz.xworkzapp.bloodbank.dao.BloodBankDAOImpl;

public class BloodBankServiceImpl implements BloodBankService {
	
    private BloodBankDAO bankDAO;
    
    public  BloodBankServiceImpl() {
    	
    	bankDAO = new BloodBankDAOImpl();
    	
    }

	@Override
	public void validateAndSave(BloodBankDTO bDTO) throws ClassNotFoundException, SQLException {
		
			if (bDTO != null) {
				if (bDTO.getDonorAge() > 18 && bDTO.getDonorName() != null) {
					bankDAO.createBloodBankDetails(bDTO);
				}
				else {
					System.out.println("Age below 18 cant accept blood");
				}
			}
			else {
				System.out.println("Invalid entry , please try again");
			}	
		
	}

	@Override
	public void validateAndUpdateAgeByName(int donorAge,String donorName) throws ClassNotFoundException, SQLException {
			if (donorAge > 18 && donorName !=null) {
				bankDAO.deleteDetailsByName(donorName);
			}
			else {
				System.out.println("Age below 18 cant accept blood");
			}
	}

	@Override
	public void deleteDetailsByName(String donorName) throws ClassNotFoundException, SQLException {
		if (donorName !=null) {
			bankDAO.deleteDetailsByName(donorName);
		}
		else {
			System.out.println("Name cant be empty");
		}
	
		
	}

	@Override
	public List<BloodBankDTO>  validateAndFetch() throws ClassNotFoundException, SQLException {
		return bankDAO.getAllBloodBankDetails();
		
	}

}
