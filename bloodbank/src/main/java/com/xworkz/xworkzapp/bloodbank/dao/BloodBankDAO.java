package com.xworkz.xworkzapp.bloodbank.dao;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.bloodbank.dto.BloodBankDTO;

public interface BloodBankDAO {
	
	public void createBloodBankDetails(BloodBankDTO bloodDTO) throws ClassNotFoundException ,SQLException;
	public void updateAgeByName(int donorAge,String donorName) throws ClassNotFoundException ,SQLException;
	public void deleteDetailsByName(String donorName) throws ClassNotFoundException ,SQLException;
	public List<BloodBankDTO> getAllBloodBankDetails() throws ClassNotFoundException,SQLException;

}
