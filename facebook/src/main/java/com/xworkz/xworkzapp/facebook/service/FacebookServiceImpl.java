package com.xworkz.xworkzapp.facebook.service;

import com.xworkz.xworkzapp.facebook.dao.FacebookDAO;
import com.xworkz.xworkzapp.facebook.dao.FacebookDAOImpl;
import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

public class FacebookServiceImpl implements FacebookService {
	
	private FacebookDAO facebookDAO;
	
	public FacebookServiceImpl() {
		facebookDAO = new FacebookDAOImpl();
	}

	@Override
	public void validateAndSave(FacebookDTO bookDTO) {
		
		if(bookDTO!= null)
		{
			
			if(bookDTO.getId()>0&& bookDTO.getName()!=null && bookDTO.getEmail()!=null && bookDTO.getPassword()!=null) {
				
				facebookDAO.createFaceBook(bookDTO);
			}
		}
		
	}
	
	
}
