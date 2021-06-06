package com.xworkz.xworkzapp.bloodbank.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.bloodbank.dto.BloodBankDTO;

public interface BloodBankService {
	
	public void validateAndSave(BloodBankDTO bDTO) throws ClassNotFoundException, SQLException;
	public void validateAndUpdateAgeByName(int donorAge,String donorName) throws ClassNotFoundException, SQLException;
	public void deleteDetailsByName(String donorName) throws ClassNotFoundException, SQLException;
	public List<BloodBankDTO> validateAndFetch() throws ClassNotFoundException, SQLException;
	
}
