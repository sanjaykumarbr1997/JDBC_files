package com.xworkz.xworkzapp.facebook.service;

import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.facebook.dao.FacebookDAO;
import com.xworkz.xworkzapp.facebook.dao.FacebookDAOImpl;
import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

public class FacebookServiceImpl implements FacebookService {
	
	private FacebookDAO facebookDAO;
	
	public FacebookServiceImpl() {
		facebookDAO = new FacebookDAOImpl();
	}

	@Override
	public void validateAndSave(FacebookDTO bookDTO)throws ClassNotFoundException, SQLException {
		
		if(bookDTO!= null)
		{
			
			if(bookDTO.getId()>0&& bookDTO.getName()!=null) {
				
				facebookDAO.createFaceBook(bookDTO);
			}
			else {
				System.out.println("Cannot create details without name");
			}
		}
		else {
			System.out.println("Invalid entry ");
		}
		
	}

	@Override
	public List<FacebookDTO> validateAndFetchFaceBookDetails()throws ClassNotFoundException, SQLException {
		
			return facebookDAO.getAllFaceBookDetails();
			
		}

	@Override
	public void validateAndUpdate(String password, String name) throws ClassNotFoundException, SQLException {
		if(password!=null && name!=null) {
			
			facebookDAO.updatePasswordByName(password, name);
		}
		else {
			System.out.println("Null values are not allowed");
		}
	}

	@Override
	public void validateAndDelete(String name) throws ClassNotFoundException, SQLException {
		if( name!=null) {
			
			facebookDAO.deleteDetailsByName(name);
		}
		else {
			System.out.println("Null values are not allowed");
		}
	}

	@Override
	public List<String> validateAndgetAllEmails() throws ClassNotFoundException, SQLException {
		return facebookDAO.getAllEmails();
	}

	@Override
	public List<String> validateAndGetPasswordByEmail(String email) throws ClassNotFoundException, SQLException {
		return facebookDAO.getPasswordByEmail(email);
	}

	@Override
	public List<String> validateGetEmailByName(String name) throws ClassNotFoundException, SQLException {
		
		return facebookDAO.getEmailByName(name);
	}
}
