package com.xworkz.xworkzapp.facebook.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

public interface FacebookService {
	public void validateAndSave(FacebookDTO bookDTO) throws ClassNotFoundException, SQLException;
	public List<FacebookDTO> validateAndFetchFaceBookDetails()throws ClassNotFoundException, SQLException;
	public void validateAndUpdate(String password,String name) throws ClassNotFoundException ,SQLException;
	public void validateAndDelete(String name) throws ClassNotFoundException ,SQLException;
	public List<String> validateAndgetAllEmails()throws ClassNotFoundException, SQLException;
	public List<String> validateAndGetPasswordByEmail(String email)throws ClassNotFoundException, SQLException;
	public List<String> validateGetEmailByName(String name)throws ClassNotFoundException, SQLException;
}
