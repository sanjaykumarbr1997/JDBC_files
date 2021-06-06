package com.xworkz.xworkzapp.facebook.dao;


import java.sql.SQLException;
import java.util.List;

import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;

public interface FacebookDAO  {

    public void createFaceBook(FacebookDTO bookDTO) throws ClassNotFoundException, SQLException;
    public List<FacebookDTO> getAllFaceBookDetails() throws ClassNotFoundException, SQLException;
    public void updatePasswordByName(String password,String name) throws ClassNotFoundException ,SQLException;
	public void deleteDetailsByName(String name) throws ClassNotFoundException ,SQLException;
	public List<String> getAllEmails()throws ClassNotFoundException, SQLException;
	public List<String> getPasswordByEmail(String email)throws ClassNotFoundException, SQLException;
	public List<String> getEmailByName(String name)throws ClassNotFoundException, SQLException;
    
   
}
